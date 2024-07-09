package com.master.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.dto.DepartmentDto;
import com.master.entity.Department;
import com.master.mapping.MapDepartmentDto;
import com.master.repository.DepartmentRepository;
import com.master.service.ServiceDepartment;

@Service
public class ServiceDepartmentImpl implements ServiceDepartment 
{
	@Autowired
	DepartmentRepository departmentDao;
	
	@Autowired
	MapDepartmentDto departmentDto;

	@Override
	public DepartmentDto addDepartment(DepartmentDto dto) {
		Department department = departmentDto.dtoToDepartment(dto);
		departmentDao.save(department);
		return departmentDto.departmentToDto(department);
	}

	@Override
	public List<DepartmentDto> fetchAllDeparment() {
		List<Department> department = departmentDao.findAll();
		List<DepartmentDto> deptDto = department.stream()
					.map(dept -> departmentDto.departmentToDto(dept))
					.collect(Collectors.toList());
		return deptDto;
	}

	@Override
	public DepartmentDto fetchDepartmentById(int id) {
		Optional<Department> search = departmentDao.findById(id);
		Department department = search.get();
		return departmentDto.departmentToDto(department);
	}

	@Override
	public DepartmentDto updateDepartment(int id, DepartmentDto dto) {
		Optional<Department> search = departmentDao.findById(id);
		Department department = search.get();
		Department updateDepartment = Department.builder()
												.deptId(department.getDeptId())
												.deptName(dto.getDeptName())
												.build();
		departmentDao.save(updateDepartment);
		return departmentDto.departmentToDto(updateDepartment);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentDao.deleteById(id);
	}
}
