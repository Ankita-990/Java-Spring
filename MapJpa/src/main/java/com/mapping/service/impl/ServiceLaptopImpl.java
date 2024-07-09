package com.mapping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.dto.LaptopDto;
import com.mapping.entity.Laptop;
import com.mapping.map.MapLaptopDto;
import com.mapping.repository.LaptopRepository;
import com.mapping.service.ServiceLaptop;

@Service
public class ServiceLaptopImpl implements ServiceLaptop
{
	@Autowired
	LaptopRepository laptopRepository;
	
	@Autowired
	MapLaptopDto laptopDto;
	
	public List<LaptopDto> laptopList() {
		List<Laptop> laptop = laptopRepository.findAll();
		List<LaptopDto> laptopList = laptop.stream()
				.map(lapt -> laptopDto.laptopToDto(lapt))
				.collect(Collectors.toList());
		return laptopList;
	}

	@Override
	public LaptopDto addLaptop(LaptopDto laptop) {
		Laptop getLaptop = laptopDto.dtoToLaptop(laptop);
		laptopRepository.save(getLaptop);
		return laptopDto.laptopToDto(getLaptop);
	}

	@Override
	public LaptopDto getLaptopById(int id) {
		Optional<Laptop> find = laptopRepository.findById(id);
		Laptop laptop = find.get();
		return laptopDto.laptopToDto(laptop);
	}

	@Override
	public LaptopDto updateLaptop(int id, LaptopDto dto) {
		Optional<Laptop> search = laptopRepository.findById(id);
		Laptop laptop = search.get();
		Laptop updatedLaptop = Laptop.builder()
										.laptopId(laptop.getLaptopId())
										.model(dto.getModel())
										.price(dto.getPrice())
										.student(dto.getStudent())
										.build();
		laptopRepository.save(updatedLaptop);
		return laptopDto.laptopToDto(updatedLaptop);
	}

	@Override
	public void deleteLaptop(int id) {
		laptopRepository.deleteById(id);
	}
}
