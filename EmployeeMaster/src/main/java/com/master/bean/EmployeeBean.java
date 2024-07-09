package com.master.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.master.model")
public interface EmployeeBean
{
	Integer getEid();
	String getEname();
	String getLocation();
	Integer getAge();
	String getJobName();
	String getDeptName();
	Double getSalary();
}