package com.mapping.service;

import java.util.List;

import com.mapping.dto.LaptopDto;

public interface ServiceLaptop 
{
	List<LaptopDto> laptopList();
	LaptopDto addLaptop(LaptopDto laptop);
	LaptopDto getLaptopById(int id);
	LaptopDto updateLaptop(int id, LaptopDto dto);
	void deleteLaptop(int id);
}
