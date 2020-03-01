package com.swageat.dos;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.swageat.constants.PaymentStatus;

import lombok.Data;
@Data
public class Order extends BaseDO {

	protected List<MenuItem> dishes;
	@OneToOne
	protected Restaurant restaurant;
	@OneToOne
	protected Address deliveryAddress;
	protected double totalPrice;
	@Enumerated(EnumType.STRING)
	protected PaymentStatus paymentStatus;
	protected String deliveryInstructions;
	@ManyToOne
	protected Valet valet;
	@ManyToOne
	protected Customer customer;
	protected Date orderDate;
	@ManyToOne
	protected Delivery delivery;
	

}
