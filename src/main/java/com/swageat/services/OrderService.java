package com.swageat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.swageat.constants.Status;
import com.swageat.dos.Order;
import com.swageat.repositories.OrderRepository;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public void setOrderRepo(OrderRepository orderRepo){
		this.orderRepo=orderRepo;
	}
	
   public String updateOrderStatus(Status status) {
		
		//orderRepo update status.
		return null;
	}
	

   public Long placeOrder(Long customerId,Order order) {
		//add order;
	     orderRepo.save(order);
	     //Do rest of the processing.
	     //orderRepo update status.
		return order.getId();
	}
	public List<Order> getAllRequestedOrderForrestId(Long restId){
		return this.orderRepo.findAllPendingOrdersForRestaurant(restId);
	}
	
	public Order getOrder(Long orderId){
		return this.orderRepo.findById(orderId).get();
	}	
	
	public List<Order> getAllPendingOrderOfCustomer(Long customerId){
		return orderRepo.findAllPendingOrdersForCustomer(customerId);
	}
	public List<Order> getAllDeliveredOrderOfCustomer(Long customerId){
		return orderRepo.findAllDeliveredOrdersForCustomer(customerId);
	}
	public String getDeliveryStatusOfOrderId(Long orderId){
		
		//find order and then take delivery id from  there and return status
		
		return null;
	}
}
