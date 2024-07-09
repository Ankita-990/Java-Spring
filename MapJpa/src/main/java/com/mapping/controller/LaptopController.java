package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.dto.LaptopDto;
import com.mapping.service.ServiceLaptop;

@RestController
@RequestMapping("/map")
public class LaptopController 
{
	@Autowired
	ServiceLaptop serviceLaptop;
	
	@PostMapping("/laptop")
	public LaptopDto newLaptop(@RequestBody LaptopDto laptop) {
		return serviceLaptop.addLaptop(laptop);
	}
	
	@GetMapping("/laptop")
	public List<LaptopDto> fetchLaptop() {
		return serviceLaptop.laptopList();
	}
	
	@GetMapping("/laptop/{id}")
	public LaptopDto fetchLaptopById(@PathVariable int id) {
		return serviceLaptop.getLaptopById(id);
	}
	
	@PutMapping("/laptop/{id}")
	public LaptopDto update(@PathVariable int id, @RequestBody LaptopDto dto) {
		return serviceLaptop.updateLaptop(id, dto);
	}
	
	@DeleteMapping("/laptop/{id}")
	public void delete(@PathVariable int id) {
		serviceLaptop.deleteLaptop(id);
	}
	
}
