package com.swageat.dos;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.swageat.constants.CustomerType;

import lombok.Data;

@Data
public class Customer extends User{

	@OneToMany
	protected List<Address> addresses;
	@Enumerated(EnumType.STRING)
	protected CustomerType type;
	@OneToMany(mappedBy="customer")
	private List<Order> orders;
	//list of liked restaurants;
}
