package com.swageat.services;

import java.util.List;

import com.swageat.dos.Address;

public interface AddressService {

	
	void addAddress(Address address);
	void updateAddressForUser(Long userId,Address address);
	List<Address> getAllAddressForUser(Address address);
	
}
