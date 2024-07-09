package com.mapping.map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mapping.dto.AddressDto;
import com.mapping.entity.Address;

@Component
public class MapAddressDto 
{
	@Autowired
	ModelMapper modelMapper;
	
	public AddressDto addressToDto(Address address) {
		return this.modelMapper.map(address, AddressDto.class);
	}
	
	public Address dtoToAddress(AddressDto dto) {
		return this.modelMapper.map(dto, Address.class);
	}
}
