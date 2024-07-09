package com.mapping.dto;

import com.mapping.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto 
{
	private Integer laptopId;
	private String model;
	private Double price;
	private Student student;
}
