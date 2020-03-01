package com.swageat.services;

import java.util.List;

import com.swageat.dos.Order;

public interface UserOrderService {

	List<Order> orders(Long userId);
	List<Order> orderHistory(Long userId);
}
