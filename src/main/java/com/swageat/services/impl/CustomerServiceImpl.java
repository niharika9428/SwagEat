package com.swageat.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.swageat.dos.Customer;
import com.swageat.dos.MenuItem;
import com.swageat.dos.Order;
import com.swageat.dos.OrderLine;
import com.swageat.dos.User;
import com.swageat.repositories.CustomerRepository;
import com.swageat.services.CustomerService;

@Service("customerService")
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	public Customer update(Customer customer) {
		customerRepo.save(customer);
		return customer;
	}

	public List<Order> orders() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> orderHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Order addToCart(MenuItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order updateCart(OrderLine updatedOrderLine) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order removeFromOrder(OrderLine removeOrderLine) {
		// TODO Auto-generated method stub
		return null;
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

}
