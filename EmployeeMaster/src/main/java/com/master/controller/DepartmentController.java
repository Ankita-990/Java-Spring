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

import com.master.dto.DepartmentDto;
import com.master.service.ServiceDepartment;

@RestController
@RequestMapping("/project")
public class DepartmentController 
{
	@Autowired
	ServiceDepartment serviceDepartment;
	
	@PostMapping("/department")
	public ResponseEntity<DepartmentDto> newDepartment(@RequestBody DepartmentDto dto) {
		serviceDepartment.addDepartment(dto);
		return new ResponseEntity<DepartmentDto>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<DepartmentDto>> departmentList() {
		List<DepartmentDto> dto = serviceDepartment.fetchAllDeparment();
		return new ResponseEntity<List<DepartmentDto>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/department/{deptId}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable int deptId) {
		DepartmentDto dto = serviceDepartment.fetchDepartmentById(deptId);
		return new ResponseEntity<DepartmentDto>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/department/{deptId}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int deptId, @RequestBody DepartmentDto dto){
		DepartmentDto department = serviceDepartment.updateDepartment(deptId, dto);
		return new ResponseEntity<DepartmentDto>(department, HttpStatus.OK);
	}
	
	@DeleteMapping("/department/{deptId}")
	public ResponseEntity<DepartmentDto> deleteDepartment(@PathVariable int deptId) {
		serviceDepartment.deleteDepartment(deptId);
		return new ResponseEntity<DepartmentDto>(HttpStatus.OK);
	}
	
	
}
