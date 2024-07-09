package com.mapping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.bean.Bean;
import com.mapping.dto.StudentDto;
import com.mapping.entity.Student;
import com.mapping.map.MapStudentDto;
import com.mapping.repository.StudentRepository;
import com.mapping.service.ServiceStudent;

@Service
public class ServiceStudentImpl implements ServiceStudent
{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	MapStudentDto studentDto;

	@Override
	public List<StudentDto> studentList() {
		List<Student> student = studentRepository.findAll();
		List<StudentDto> studList = student.stream()
				.map(stud -> studentDto.studentToDto(stud))
				.collect(Collectors.toList());
		return studList;
	}

	@Override
	public StudentDto addStudent(StudentDto student) {
		Student getStudent = studentDto.dtoToStudent(student);
		studentRepository.save(getStudent);
		return studentDto.studentToDto(getStudent);
	}

	@Override
	public StudentDto getStudentById(int id) {
		Optional<Student> find = studentRepository.findById(id);
		Student student = find.get();
		return studentDto.studentToDto(student);
	}

	@Override
	public StudentDto updateStudent(int id, StudentDto dto) {
		Optional<Student> search = studentRepository.findById(id);
		Student student  = search.get();
		Student updatedStudent = Student.builder()
										.studentId(student.getStudentId())
										.studentName(dto.getStudentName())
										.percentage(dto.getPercentage())
										.courses(dto.getCourses())
										.build();
		studentRepository.save(updatedStudent);
		return studentDto.studentToDto(updatedStudent);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Bean> joinTable() {
		return studentRepository.getJoinTable();
	}

	@Override
	public List<Bean> joinTableById(Integer studentId) {
		return studentRepository.getJoinTableById(studentId);
	}

}
