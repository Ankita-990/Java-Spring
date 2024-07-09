package com.mapping.dto;

import java.util.List;

import com.mapping.entity.Address;
import com.mapping.entity.Course;
import com.mapping.entity.Laptop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto 
{
	private Integer studentId;
	private String studentName;
	private Double percentage;
	private List<Course> courses;
}
