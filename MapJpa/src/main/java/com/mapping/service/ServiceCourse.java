package com.mapping.service;

import java.util.List;

import com.mapping.dto.CourseDto;

public interface ServiceCourse 
{
	List<CourseDto> courseList();
	CourseDto newCourse(CourseDto dto);
	CourseDto getCourseById(int id);
	CourseDto updateCourse(int id, CourseDto dto);
	void deleteCourse(int id);
}
