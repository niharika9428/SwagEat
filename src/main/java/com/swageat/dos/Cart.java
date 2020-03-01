package com.swageat.dos;

import lombok.Data;

@Data
public class Cart {

	protected Order order;
	protected double totalCartValue;
	protected int noOfItems;
	
}
