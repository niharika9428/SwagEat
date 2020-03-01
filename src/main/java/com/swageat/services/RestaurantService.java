package com.swageat.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swageat.dos.Menu;
import com.swageat.dos.Restaurant;
import com.swageat.repositories.RestaurantRepository;

@Service
public class RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private MenuService menuService;

	public String processOrder(Long orderId) {
		//accept , reject , confirm
		//notify
		return null;
	}
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public Optional<Restaurant> findById(Long id) {
		
		Optional<Restaurant> restaurant = restaurantRepository.findById(id);
		return restaurant;
	}

	public void saveAll(List<Restaurant> restaurants) {
		restaurantRepository.saveAll(restaurants);
	}

	public void deleteAll() {
		// delete all the menu and menu items.
		restaurantRepository.deleteAll();
	}

	public void deleteById(Long id) {
		//business logic delete menu and menu item related.
		restaurantRepository.deleteById(id);
	}
	
	public List<Menu> getMenusOfRestaurant(Long restaurantId) {
		 Optional<Restaurant> rest = restaurantRepository.findById(restaurantId);
	        if (rest != null)
	            return menuService.findByRestaurantId(restaurantId);
	        return new LinkedList<Menu>();
	}
	
	public void addMenusToRestaurant(Long restId, List<Menu> menus) {
		 Optional<Restaurant> rest = restaurantRepository.findById(restId);
	        if (rest.isEmpty())
	            return ;

	        for(Menu menu : menus)
	            menu.setRestaurant(rest.get());
	        menuService.saveAll(menus);
	}

	public void deleteMenus(Long restId) {
		 Optional<Restaurant> rest = restaurantRepository.findById(restId);
	        if (rest.isEmpty())
	            return ;
	        menuService.deleteByRestaurantId(restId);
		
	}
	
	
}
