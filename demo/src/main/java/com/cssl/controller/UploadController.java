package com.cssl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.cssl.pojo.Emp;
import com.cssl.service.EmpService;
import com.cssl.vo.EmpVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Scope("singleton")
@Controller
public class UploadController{

	private EmpService service;
	@Autowired
	public UploadController(EmpService service) {
		System.out.println("--------------UploadController ����:"+service);
		this.service = service;
	}
	@Autowired
	private ServletContext application;
	
	@GetMapping("/index")
	public String index() {
		System.out.println("index...");
		return "forward:/index.html";
	}
	
	@PostMapping("/regist")
	public String regist(EmpVo evo,BindingResult br) {
		if(br.hasErrors()) {
			return "index";
		}
		System.out.println("regist:"+evo);
		Emp emp=new Emp();
		BeanUtils.copyProperties(evo, emp);
		//return "forward:/success.jsp";
		if(service.saveUsers(emp)) {
			return "success";
		}
		return "index";
	}
	@GetMapping("/select")
	public String select(){
		PageInfo<Emp> page=service.queryEmp(2, 5);
		System.out.println(page.getSize());
		List<Emp> list=page.getList();
		list.forEach(System.out::println);
		return "success";
	}
	@ResponseBody
	@RequestMapping("/find/{pageIndex}/{pageSize}")
	public Page<Emp> find(
			@PathVariable int pageIndex,
			@PathVariable int pageSize){
		log.error("出错了："+pageIndex);
		return service.find(pageIndex, pageSize);
	}
	/**
	 * ����
	 * @param fileName
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("/download")
	public void download(String fileName,HttpServletResponse response) throws Exception {
		System.out.println("download:"+fileName);
		response.setContentType("application/x-msdownload;charset=UTF-8");	
		response.setHeader("Content-disposition", "attachment;filename="+fileName);
		OutputStream out = response.getOutputStream();
		String path = application.getRealPath("/upload"); 
		InputStream in = new FileInputStream(path+File.separator+fileName);
		//����
		byte[] b = new byte[4096];
		int len = in.read(b);
		while(len!=-1) {
			out.write(b, 0, len);
			len = in.read(b);
		}
		out.flush();
		out.close();
	}
	/**
	 * �ļ��ϴ�
	 * @param title
	 * @param files
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="upload")
	public String upload(String title,MultipartFile[] files) throws Exception {
		System.out.println("upload:"+title+"\t"+files.length);
		String path=application.getRealPath("/upload");
		System.out.println("path:"+path);
		List<String> types=Arrays.asList("image/jpeg","image/gif","image/png");
		if(files!=null&&files.length>0) {
			for (MultipartFile file : files) {
				if(!file.isEmpty()) {
					if(types.contains(file.getContentType())) {
						String uuid=UUID.randomUUID().toString();
						//����
						System.out.println("type:"+file.getContentType());
						//����
						System.out.println("name:"+file.getOriginalFilename());
						//�ֽڳ���
						System.out.println("size:"+file.getSize()+"byte");
						File df=new File(path+File.separator+uuid+file.getOriginalFilename());
						file.transferTo(df);
					}
				}
			}
		}
		return "success";
	}
	
}
