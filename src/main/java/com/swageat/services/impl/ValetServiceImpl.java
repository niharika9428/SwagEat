package com.swageat.services.impl;

import java.util.List;

import com.swageat.constants.Status;
import com.swageat.dos.Order;
import com.swageat.dos.Rating;
import com.swageat.dos.User;
import com.swageat.services.UserOrderService;
import com.swageat.services.UserService;

public class ValetServiceImpl implements UserService,UserOrderService{
	
	
	public int getTopRating(Long userId) {
		return 0;
	}
	
	public void updateRatingByUser(Rating Rating) {
	}
	
	public void getAllOrdersDelivered(Long userId) {
		//get all orders where valet was this user id.
	}

	public void getAllPendingOrders(Long userId) {
		//get all orders where valet was this user id.
	}
	
	public void updateOrderStatus(Long userId,Long orderId,Status status) {
		//get  order and mark status where valet was this user id.
	}
	
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhoneNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> orders(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> orderHistory(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
