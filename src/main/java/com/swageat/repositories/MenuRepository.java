package com.swageat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swageat.dos.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByRestaurant_Id(Long id);

	void deleteByRestaurant_Id(Long id);
}
