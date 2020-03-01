package com.swageat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.swageat.dos.Order;


@Repository
@Transactional(propagation=Propagation.REQUIRED)
public interface OrderRepository extends JpaRepository<Order, Long>  {

	@Query("select distinct ol.order FROM OrderLine as ol JOIN ol.menuItem as f WHERE f.restaurant.id= ?1 AND ol.order.delivery IS NULL")
    public List<Order> findAllPendingOrdersForRestaurant(Long restId);
	
	@Query("select distinct o "
			+ "FROM OrderLine as ol "
			+ "JOIN ol.order o "
			+ "JOIN ol.menuItem as f "
			+ "WHERE o.customer.id= ?1")
    public List<Order> findAllPendingOrdersForCustomer(Long customerId);

	@Query("select distinct ol.order FROM OrderLine as ol JOIN ol.menuItem as f WHERE ol.order.customer.id= ?1 AND ol.order.delivery.status = 'COMPLETE'")
    public List<Order> findAllDeliveredOrdersForCustomer(Long customerId);

	@Query("select distinct ol.order FROM OrderLine as ol JOIN ol.menuItem as f WHERE f.restaurant.id= ?1 AND ol.order.delivery.status = 'PENDING'")
	public List<Order> findAllInProgressOrdersForRestaurant(Long restId);
	
	@Query("select distinct ol.order FROM OrderLine as ol JOIN ol.menuItem as f WHERE f.restaurant.id= ?1 AND ol.order.delivery.status = 'COMPLETE'")
	public List<Order> findAllDeliveredOrdersForRestaurant(Long restId);
	
}
