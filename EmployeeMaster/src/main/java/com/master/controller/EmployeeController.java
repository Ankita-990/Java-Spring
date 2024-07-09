package com.master.controller;

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

import com.master.dto.EmployeeDto;
import com.master.entity.Employee;
import com.master.service.ServiceEmployee;


@RestController
@RequestMapping("/project")
public class EmployeeController 
{
	@Autowired
	ServiceEmployee serviceEmployee;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> add(@RequestBody EmployeeDto dto) {
		serviceEmployee.addEmployee(dto);
		return new ResponseEntity<EmployeeDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> employeeList() {
		List<EmployeeDto> dto = serviceEmployee.fetchAllEmployee();
		return new ResponseEntity<List<EmployeeDto>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{eid}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int eid) {
		EmployeeDto employee = serviceEmployee.fetchEmployeeById(eid);
		return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
	}
	
	@PutMapping("/employee/{eid}")
	public ResponseEntity<EmployeeDto> update(@PathVariable int eid, @RequestBody EmployeeDto dto) {
		EmployeeDto employee = serviceEmployee.updateEmployee(eid, dto);
		return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{eid}")
	public ResponseEntity<EmployeeDto> delete(@PathVariable int eid) {
		serviceEmployee.deleteEmployee(eid);
		return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
}
