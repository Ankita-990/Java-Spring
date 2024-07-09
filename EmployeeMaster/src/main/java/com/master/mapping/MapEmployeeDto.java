package com.master.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.dto.EmployeeDto;
import com.master.entity.Employee;

@Component
public class MapEmployeeDto {
	
	@Autowired
	ModelMapper modelMapper;
	
	// Employee to Dto
		public EmployeeDto employeeToDto(Employee employee) {
			EmployeeDto dto = this.modelMapper.map(employee, EmployeeDto.class);
			return dto;
		}
			
		// Dto to Employee
		public Employee dtoToEmployee(EmployeeDto dto) {
			Employee employee = this.modelMapper.map(dto, Employee.class);
			return employee;
		}
}
