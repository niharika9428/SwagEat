package com.swageat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.swageat.dos.Order;
import com.swageat.services.OrderService;

@RestController
public class OrderController {

	  @Autowired
	  OrderService orderService;
		
	  @RequestMapping("/{customerId}")
	  @ResponseStatus(HttpStatus.OK)
	  public List<Order> getOrders(@PathVariable("customerId") Long customerId) {
	       return orderService.getAllPendingOrderOfCustomer(customerId);
	  }
	  
	  @PostMapping("/{customerId}/order/")
	  @ResponseStatus(HttpStatus.OK)
	  public Long placeOrder(@PathVariable("customerId") Long customerId,@RequestBody Order order) {
	       return orderService.placeOrder(customerId,order);
	  }
}
