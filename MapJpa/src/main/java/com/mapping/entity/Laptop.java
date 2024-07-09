package com.mapping.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laptop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Laptop 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer laptopId;
	
	@Column(name = "laptop_model")
	private String model;
	
	@Column(name = "price")
	private Double price;
	
	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;
	
	
	
//	@OneToOne(mappedBy = "laptop")
//	@JoinColumn(insertable = false, nullable = true)
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_id", referencedColumnName = "sid")
//	private Student student;
}
