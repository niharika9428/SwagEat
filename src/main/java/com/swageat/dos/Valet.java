package com.swageat.dos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class Valet extends User{

	protected Address addresses;
	@OneToMany(mappedBy = "valet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	protected List<Rating> rating;
	protected String panCardNumber;
	protected int experience;
	
}
