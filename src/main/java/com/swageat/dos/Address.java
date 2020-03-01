package com.swageat.dos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.swageat.constants.AddressType;

import lombok.Data;
@Data
public class Address extends BaseDO{

	protected String houseNumber;
	protected String streetAddress;
	protected String landMark;
	protected String city;
	protected String country;
	@Enumerated(EnumType.STRING)
	protected AddressType type;
	@ManyToOne
	User user;
	
}
