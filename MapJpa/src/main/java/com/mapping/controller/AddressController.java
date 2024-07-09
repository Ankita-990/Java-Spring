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

import com.mapping.dto.AddressDto;
import com.mapping.service.ServiceAddress;

@RestController
@RequestMapping("/map")
public class AddressController 
{
	@Autowired
	ServiceAddress serviceAddress;
	
	@GetMapping("/address")
	public List<AddressDto> fetchAddress() {
		return serviceAddress.addressList();
	}
	
	@GetMapping("/address/{id}")
	public AddressDto fetchAddressById(@PathVariable int id) {
		return serviceAddress.getAddressById(id);
	}
	
	@PostMapping("/address")
	public AddressDto addAddress(@RequestBody AddressDto dto) {
		return serviceAddress.newAddress(dto);
	}
	
	@PutMapping("/address/{id}")
	public AddressDto update(@PathVariable int id, @RequestBody AddressDto dto) {
		return serviceAddress.updateAddress(id, dto);
	}
	
	@DeleteMapping("/address/{id}")
	public void delete(@PathVariable int id) {
		serviceAddress.deleteAddress(id);
	}
	
}
