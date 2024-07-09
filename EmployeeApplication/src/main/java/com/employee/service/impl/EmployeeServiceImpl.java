package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto dto) {
		Employee employee = this.dtoToEmployee(dto);
		Employee newEmployee = employeeRepository.save(employee);
		return this.employeeToDto(newEmployee);
	}

	@Override
	public EmployeeDto getEmployee(int id) {
//		Employee employee = employeeDto.dtoToEmployee(dto);
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		Employee getEmployee = findEmployee.get();
		return this.employeeToDto(getEmployee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDto = employees.stream()
											.map(emp -> this.employeeToDto(emp))
											.collect(Collectors.toList());
		return new ArrayList<>(employeeDto);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto, int id) {
		Employee employee = this.dtoToEmployee(dto);
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		Employee updateEmployee = findEmployee.get();
		updateEmployee.setName(employee.getName());
		updateEmployee.setAge(employee.getAge());
		updateEmployee.setSalary(employee.getSalary());
		updateEmployee.setCity(employee.getCity());
		Employee updated = employeeRepository.save(updateEmployee);
		return this.employeeToDto(updated);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}


	
	public Employee dtoToEmployee(EmployeeDto dto) {
		Employee employee = this.modelMapper.map(dto, Employee.class);
		return employee;
	}
	
	public EmployeeDto employeeToDto(Employee employee) {
		EmployeeDto dto = this.modelMapper.map(employee, EmployeeDto.class);
		return dto;
	}
	
}
