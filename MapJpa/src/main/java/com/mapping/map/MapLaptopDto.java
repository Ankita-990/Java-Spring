package com.mapping.map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mapping.dto.LaptopDto;
import com.mapping.entity.Laptop;

@Component
public class MapLaptopDto 
{
	@Autowired
	ModelMapper modelMapper;
	
	public LaptopDto laptopToDto(Laptop laptop) {
		LaptopDto dto = this.modelMapper.map(laptop, LaptopDto.class);
		return dto;
	}
	
	public Laptop dtoToLaptop(LaptopDto dto) {
		Laptop laptop = this.modelMapper.map(dto, Laptop.class);
		return laptop;
	}
}
