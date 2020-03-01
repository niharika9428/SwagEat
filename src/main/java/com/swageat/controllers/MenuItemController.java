package com.swageat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.swageat.dos.MenuItem;
import com.swageat.repositories.MenuItemRepository;

import java.util.List;

@RestController
@RequestMapping("/menuItems")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @GetMapping("/")
    public List<MenuItem> getMenItems() {
        return menuItemRepo.findAll();
    }

    @GetMapping("/{id}")
    public MenuItem findMenuById(@PathVariable("id") Long id) {
        return menuItemRepo.findById(id).get();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItemList) {
        menuItemRepo.saveAll(menuItemList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        menuItemRepo.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
    	 menuItemRepo.deleteById(id);
    }

}
