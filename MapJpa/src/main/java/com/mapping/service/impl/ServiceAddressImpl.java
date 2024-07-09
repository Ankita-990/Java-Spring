package com.mapping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.dto.AddressDto;
import com.mapping.entity.Address;
import com.mapping.map.MapAddressDto;
import com.mapping.repository.AddressRepository;
import com.mapping.service.ServiceAddress;

@Service
public class ServiceAddressImpl implements ServiceAddress
{
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	MapAddressDto addressDto;
	

	@Override
	public List<AddressDto> addressList() {
		List<Address> address = addressRepository.findAll();
		List<AddressDto> dto = address.stream()
										.map(addr -> addressDto.addressToDto(addr))
										.collect(Collectors.toList());
		return dto;
	}

	@Override
	public AddressDto newAddress(AddressDto dto) {
		Address address = addressDto.dtoToAddress(dto);
		addressRepository.save(address);
		return addressDto.addressToDto(address);
	}

	@Override
	public AddressDto getAddressById(int id) {
		Optional<Address> find = addressRepository.findById(id);
		Address address = find.get();
		return addressDto.addressToDto(address);
	}

	@Override
	public AddressDto updateAddress(int id, AddressDto dto) {
		Optional<Address> search = addressRepository.findById(id);
		Address address = search.get();
		
		Address updatedAddress = Address.builder()
										.addressId(address.getAddressId())
										.city(dto.getCity())
										.country(dto.getCountry())
										.student(dto.getStudent())
										.build();
		addressRepository.save(updatedAddress);
		return addressDto.addressToDto(updatedAddress);
	}

	@Override
	public void deleteAddress(int id) {
		addressRepository.deleteById(id);
	}

}
