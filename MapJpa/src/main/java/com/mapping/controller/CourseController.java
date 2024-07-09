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

import com.mapping.dto.CourseDto;
import com.mapping.service.ServiceCourse;

@RestController
@RequestMapping("/map")
public class CourseController {

	@Autowired
	ServiceCourse serviceCourse;
	
	@PostMapping("/course")
	public CourseDto addCourse(@RequestBody CourseDto dto) {
		return serviceCourse.newCourse(dto);
	}
	
	@GetMapping("/course")
	public List<CourseDto> fetchCourse() {
		return serviceCourse.courseList();
	}
	
	@GetMapping("/course/{id}")
	public CourseDto fetchCourseById(@PathVariable int id) {
		return serviceCourse.getCourseById(id);
	}
	
	@PutMapping("/course/{id}")
	public CourseDto update(@PathVariable int id, @RequestBody CourseDto dto) {
		return serviceCourse.updateCourse(id, dto);
	}
	
	
	@DeleteMapping("/course/{id}")
	public void delete(@PathVariable int id) {
		serviceCourse.deleteCourse(id);
	}
	
}
