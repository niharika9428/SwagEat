package com.swageat.dos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.swageat.constants.Status;

import lombok.Data;

@Data
@Entity
public class Delivery {
	@Id
	@GeneratedValue
	private long id;
	private Date startDateTime;
	private Date endDateTime;
	private long distance;
	

	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Delivery(){
		orders = new ArrayList<Order>();
	}

	@OneToMany(mappedBy="delivery", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Order> orders;
	
	public void addOrder(Order order){
		orders.add(order);
		order.setDelivery(this);
	}
}
