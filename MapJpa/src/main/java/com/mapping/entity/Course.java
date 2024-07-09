package com.mapping.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Student> students;
	
//	@ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
//	@JoinColumn
//	private List<Student> student;
}
