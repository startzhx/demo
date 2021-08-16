package com.cssl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cssl.vo.EmpVo;

@ControllerAdvice
public class AdviceController {

	@InitBinder  
    public void initBinder(WebDataBinder binder) {
		System.out.println("initBinder...");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@ExceptionHandler(Exception.class)
	public String doException(Exception e) {
		System.out.println("Exception:"+e.getMessage());
		return "error";
	}
	
	@ModelAttribute
	public EmpVo getModel(EmpVo evo) {
		System.out.println("getModel:"+evo);
		//evo.setEname("�����û�");
		return evo;
	}
}
