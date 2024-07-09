package com.mapping.service;

import java.util.List;

import com.mapping.dto.AddressDto;

public interface ServiceAddress 
{
	List<AddressDto> addressList();
	AddressDto newAddress(AddressDto dto);
	AddressDto getAddressById(int id);
	AddressDto updateAddress(int id, AddressDto dto);
	void deleteAddress(int id);
}
