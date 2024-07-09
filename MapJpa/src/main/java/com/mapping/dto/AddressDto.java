package com.mapping.dto;

import java.util.List;

import com.mapping.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto 
{
	private Integer addressId;
	private String city;
	private String country;
	private Student student;
}
