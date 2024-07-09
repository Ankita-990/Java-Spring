package com.mapping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.dto.CourseDto;
import com.mapping.entity.Course;
import com.mapping.map.MapCourseDto;
import com.mapping.repository.CourseRepository;
import com.mapping.service.ServiceCourse;

@Service
public class ServiceCourseImpl implements ServiceCourse
{
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	MapCourseDto courseDto;

	@Override
	public List<CourseDto> courseList() {
		List<Course> courses = courseRepository.findAll();
		List<CourseDto> list = courses.stream()
										.map(course -> courseDto.courseToDto(course))
										.collect(Collectors.toList());
		return list;
	}

	@Override
	public CourseDto newCourse(CourseDto dto) {
		Course course = courseDto.dtoToCourse(dto);
		courseRepository.save(course);
		return courseDto.courseToDto(course);
	}

	@Override
	public CourseDto getCourseById(int id) {
		Optional<Course> find = courseRepository.findById(id);
		Course course = find.get();
		return courseDto.courseToDto(course);
	}

	@Override
	public CourseDto updateCourse(int id, CourseDto dto) {
		Optional<Course> search = courseRepository.findById(id);
		Course course = search.get();
		Course updatedCourse = Course.builder()
									.courseId(course.getCourseId())
									.courseName(dto.getCourseName())
									.students(dto.getStudents())
									.build();
		courseRepository.save(updatedCourse);
		return courseDto.courseToDto(updatedCourse);
	}

	@Override
	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}

}
