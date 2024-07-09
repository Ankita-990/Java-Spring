package com.mapping.map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mapping.dto.CourseDto;
import com.mapping.entity.Course;

@Component
public class MapCourseDto {
	
	@Autowired
	ModelMapper modelMapper;
	
	public CourseDto courseToDto(Course course)
	{
		return modelMapper.map(course, CourseDto.class);
	}
	
	public Course dtoToCourse(CourseDto dto) {
		return modelMapper.map(dto, Course.class);
	}

}
