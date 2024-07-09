package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;


@RestController
@RequestMapping("/")
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto dto) {
		EmployeeDto newEmployee = service.createEmployee(dto);
		return new ResponseEntity<EmployeeDto>(newEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getAllList() {
		List<EmployeeDto> empDto = service.getAllEmployee();
		return new ResponseEntity<List<EmployeeDto>>(empDto, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
		EmployeeDto getEmployee = service.getEmployee(id);
		return new ResponseEntity<EmployeeDto>(getEmployee, HttpStatus.OK);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto dto, @PathVariable int id) {
		EmployeeDto update = service.updateEmployee(dto, id);
		return new ResponseEntity<EmployeeDto>(update, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> delete(@PathVariable int id) {
		service.deleteEmployee(id);
		return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
		
}
