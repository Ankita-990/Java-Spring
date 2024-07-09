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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer addressId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;
	
//	@ManyToMany(mappedBy = "address")
//	@JoinTable(name = "student", 
//				joinColumns = @JoinColumn(name = "sid"),
//				inverseJoinColumns = @JoinColumn(name = "area_code"))	
//	private List<Student> student = new ArrayList<>();
	
}
