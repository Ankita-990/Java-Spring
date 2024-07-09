package com.master.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.dto.DepartmentDto;
import com.master.entity.Department;

@Component
public class MapDepartmentDto {

	@Autowired
	ModelMapper modelMapper;
	
	
	// Department to Dto
		public DepartmentDto departmentToDto(Department department) {
			DepartmentDto dto = this.modelMapper.map(department, DepartmentDto.class);
			return dto;
		}
		
		// Dto to Department
		public Department dtoToDepartment(DepartmentDto dto) {
			Department department = this.modelMapper.map(dto, Department.class);
			return department;
		}

	
}
