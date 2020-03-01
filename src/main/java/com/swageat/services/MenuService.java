package com.swageat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swageat.dos.Menu;
import com.swageat.repositories.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	public List<Menu> findByRestaurantId(Long id){
		return menuRepository.findByRestaurant_Id(id);
	}

	public void deleteByRestaurantId(Long id) {
		menuRepository.deleteByRestaurant_Id(id);
	}

	public void saveAll(List<Menu> menus) {
		menuRepository.saveAll(menus);
	}

	public Optional<Menu> findById(Long id) {
		
		return menuRepository.findById(id);
	}

	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	public void deleteAll() {
		menuRepository.deleteAll();
	}

	public void deleteById(Long id) {
		menuRepository.deleteById(id);
	}
	
}
