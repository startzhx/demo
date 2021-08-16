package com.cssl.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpVo {

	private Integer empno;
	private String ename;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private Integer sal;
}
