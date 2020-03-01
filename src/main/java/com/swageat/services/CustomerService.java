package com.swageat.services;

import com.swageat.dos.MenuItem;
import com.swageat.dos.Order;
import com.swageat.dos.OrderLine;

public interface CustomerService extends UserService,UserOrderService{
	
	Order addToCart(MenuItem item);
	Order updateCart(OrderLine orderLine);
	Order removeFromOrder(OrderLine orderLine);
}
