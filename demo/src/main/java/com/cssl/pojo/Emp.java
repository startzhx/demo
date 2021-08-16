package com.cssl.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Emp {

	private Integer empno;
	private String ename;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private Integer sal;

}
