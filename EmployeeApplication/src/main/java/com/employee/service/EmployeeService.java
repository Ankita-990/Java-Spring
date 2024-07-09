package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;

public interface EmployeeService 
{
	EmployeeDto createEmployee(EmployeeDto dto);
	EmployeeDto getEmployee(int id);
	List<EmployeeDto> getAllEmployee();
	EmployeeDto updateEmployee(EmployeeDto dto, int id);
	void deleteEmployee(int id);
}
