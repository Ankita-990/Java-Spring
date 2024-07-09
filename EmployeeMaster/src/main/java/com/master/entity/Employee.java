package com.master.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Entity
@Table(name = "employee")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Employee //implements EmployeeBean
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer eid;
	
	@Column(name = "emp_name")
	private String ename;
	
	@Column(name = "emp_location")
	private String location;
	
	@Column(name = "emp_age")
	private Integer age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id", referencedColumnName = "id")
	private Job job;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;
	
	@Column(name = "emp_salary")
	private Double salary;
}
