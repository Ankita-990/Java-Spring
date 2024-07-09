package com.master.dto;

import com.master.entity.Department;
import com.master.entity.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto 
{
	private int eid;
	private String ename;
	private String location;
	private int age;
	private Job job;
	private Department department;
	private double salary;
	
	
	
}
