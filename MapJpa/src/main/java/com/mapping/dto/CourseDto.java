package com.mapping.dto;

import java.util.List;

import com.mapping.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	private Integer courseId;
	private String courseName;
	private List<Student> students;
}
