package com.swageat.services;

import java.util.List;

import com.swageat.dos.MenuItem;
import com.swageat.dos.Order;
import com.swageat.dos.OrderLine;

public interface CustomerService extends UserService{
	
	List<Order> orders();
	List<Order> orderHistory();
	Order addToCart(MenuItem item);
	Order updateCart(OrderLine orderLine);
	Order removeFromOrder(OrderLine orderLine);
}
