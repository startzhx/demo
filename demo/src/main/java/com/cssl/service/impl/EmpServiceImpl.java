package com.cssl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.dao.*;
import com.cssl.pojo.*;
import com.cssl.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Transactional
@Service
public class EmpServiceImpl implements EmpService {
	
	public EmpServiceImpl() {
		System.out.println("-----------------UsersServiceImpl ����:"+this);
	}

	@Autowired
	private EmpMapper eMapper;
	
	@Override
	public boolean saveUsers(Emp emp) {
		if(eMapper.insert(emp)>0) {
			return true;			
		}
		return false;
	}

	@Override
	public PageInfo<Emp> queryEmp(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Emp> list=eMapper.select();
		return new PageInfo<Emp>(list);
	}

	@Override
	public Page<Emp> find(int pageIndex, int pageSize) {
		Page<Emp> page=PageHelper.startPage(pageIndex, pageSize);
		eMapper.select();
		return page;
	}
}
