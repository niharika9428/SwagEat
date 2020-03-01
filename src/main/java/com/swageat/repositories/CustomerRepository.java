package com.swageat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swageat.dos.Customer;


@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
