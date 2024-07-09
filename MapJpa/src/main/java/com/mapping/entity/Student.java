package com.mapping.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "percentage")
	private Double percentage;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Laptop laptop;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)//, orphanRemoval = true)
	private List<Address> address;
	
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Course> courses;
	
//	@OneToMany(targetEntity =Address.class,cascade = CascadeType.ALL )
//	@JoinColumn(name="student_id",referencedColumnName = "sid")
//	private List<Address> address;
	
}
