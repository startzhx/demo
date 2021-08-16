package com.cssl.service;

import java.util.List;

import com.cssl.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface EmpService {

	//新增
	public boolean saveUsers(Emp user);
	
	PageInfo<Emp> queryEmp(Integer pageNum,Integer pageSize);
	
	Page<Emp> find(int pageIndex,int pageSize);
}
