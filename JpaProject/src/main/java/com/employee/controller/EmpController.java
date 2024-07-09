package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController 
{
	@RequestMapping("/")
	public String home()
	{
		return "hello.jsp";
	}
}
