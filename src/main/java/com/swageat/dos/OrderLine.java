package com.swageat.dos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private Long id;
	private int quantity;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private MenuItem dish;
	
	public OrderLine() {
		
	}
	
	public OrderLine(MenuItem item) {
		this.dish = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getDish() {
		return dish;
	}

	public void setDish(MenuItem Dish) {
		this.dish = Dish;
	}

//	methods
	public double getTotalPrice(){
		return this.getDish().getPrice()*this.quantity;
	}
}