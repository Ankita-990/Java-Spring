package com.mapping.service;

import java.util.List;

import com.mapping.bean.Bean;
import com.mapping.dto.StudentDto;

public interface ServiceStudent 
{
	List<StudentDto> studentList();
	StudentDto addStudent(StudentDto student);
	StudentDto getStudentById(int id);
	StudentDto updateStudent(int id, StudentDto dto);
	void deleteStudent(int id);
	
	// Joins
	List<Bean> joinTable();
	List<Bean> joinTableById(Integer studentId);
}
