package com.mapping.map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mapping.dto.StudentDto;
import com.mapping.entity.Student;

@Component
public class MapStudentDto 
{
	@Autowired
	ModelMapper modelMapper;
	
	public StudentDto studentToDto(Student student) {
		StudentDto dto = this.modelMapper.map(student, StudentDto.class);
		return dto;
	}
	
	public Student dtoToStudent(StudentDto dto) {
		Student student = this.modelMapper.map(dto, Student.class);
		return student;
	}
}
