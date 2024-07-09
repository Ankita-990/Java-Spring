package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.bean.Bean;
import com.mapping.dto.StudentDto;
import com.mapping.service.ServiceStudent;

@RestController
@RequestMapping("/map")
public class StudentController 
{
	@Autowired
	ServiceStudent serviceStudent;
	
	@PostMapping("/student")
	public StudentDto newStudent(@RequestBody StudentDto student) {
		return serviceStudent.addStudent(student);
	}
	
	@GetMapping("/student")
	public List<StudentDto> fetchStudents()
	{
		return serviceStudent.studentList();
	}
	
	@GetMapping("/student/{id}")
	public StudentDto fetchStudentById(@PathVariable int id)
	{
		return serviceStudent.getStudentById(id);
	}
	
	@PutMapping("/student/{id}")
	public StudentDto update(@PathVariable int id, @RequestBody StudentDto dto) {
		return serviceStudent.updateStudent(id, dto);
	}
	
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable int id) {
		serviceStudent.deleteStudent(id);
	}
	
	// Join tables
	@GetMapping("/join")
	public List<Bean> join() {
		return serviceStudent.joinTable();
	}
	
	@GetMapping("/join/{studentId}")
	public List<Bean> joinById(@PathVariable Integer studentId) {
		return serviceStudent.joinTableById(studentId);
	}
	
}
