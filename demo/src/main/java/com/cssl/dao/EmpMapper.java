package com.cssl.dao;

import java.util.List;
import java.util.Map;

import com.cssl.pojo.*;

public interface EmpMapper {

	int insert(Emp e);
	
	List<Emp> select();
	
}
