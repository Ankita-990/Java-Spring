package com.mapping.bean;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.mapping.entity.Address;
import com.mapping.entity.Course;
import com.mapping.entity.Laptop;

@Configuration
public interface Bean 
{
	Integer getStudentId();
	String getStudentName();
	Double getPercentage();

//	Laptop getLaptop();
//	Integer getLaptopId();
	String getModel();
	Double getPrice();

	
//	List<Address> getAddress();
//	Integer getAddressId();
	String getCity();
	String getCountry();
	
//	List<Course> getCourse();
//	Integer getCourseId();
	String getCourseName();
}
