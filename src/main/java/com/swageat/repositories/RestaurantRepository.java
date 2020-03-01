package com.swageat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swageat.dos.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
