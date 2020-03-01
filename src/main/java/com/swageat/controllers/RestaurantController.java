package com.swageat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.swageat.dos.Menu;
import com.swageat.dos.Restaurant;
import com.swageat.services.RestaurantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

  
    @Autowired
    RestaurantService restaurantService;
	
    @RequestMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        log.info("Fetch all: " + restaurants);
        return restaurants;
    }

    @RequestMapping("/{id}")
    public ResponseEntity findRestaurantById(@PathVariable("id") Long id) {
    	Optional<Restaurant> restaurant = restaurantService.findById(id);
    	if(!restaurant.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<Restaurant>(restaurant.get(),HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRestaurants(@RequestBody List<Restaurant> restaurants) {
        log.info("save restaurants: " + restaurants);
        restaurantService.saveAll(restaurants);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        log.info("Delete all restaurants ... ");
        restaurantService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("delete restaurants by id ... ");
        restaurantService.deleteById(id);
    }

    @RequestMapping("/{id}/menus/")
    @ResponseStatus(HttpStatus.OK)
    public List<Menu> getMenus(@PathVariable("id") Long id) {
       return restaurantService.getMenusOfRestaurant(id);
    }

    @PostMapping("/{id}/menus/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenus(@PathVariable("id") Long id, @RequestBody List<Menu> menus) {
       restaurantService.addMenusToRestaurant(id,menus);
    }

    @DeleteMapping("/{id}/menus/")
    public void deleteMenus(@PathVariable("id") Long id) {
    	restaurantService.deleteMenus(id);
    }

}
