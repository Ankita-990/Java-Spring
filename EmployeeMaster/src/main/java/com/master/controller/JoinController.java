package com.master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.bean.EmployeeBean;
import com.master.service.ServiceEmployee;

@RestController
@RequestMapping("/project")
public class JoinController 
{
	@Autowired
	ServiceEmployee serviceEmployee;
	
	@GetMapping("/join")
	public List<EmployeeBean> join() {
		return serviceEmployee.joinTable();
	}
	
	@GetMapping("/join/{eid}")
	public EmployeeBean joinById(@PathVariable Integer eid) {
		return serviceEmployee.joinTableById(eid);
	}
	
}
