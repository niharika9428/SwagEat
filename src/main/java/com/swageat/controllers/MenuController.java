package com.swageat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.swageat.dos.Menu;
import com.swageat.dos.MenuItem;
import com.swageat.repositories.MenuItemRepository;
import com.swageat.services.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/")
    public List<Menu> getMenus() {
        return menuService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Menu> findMenuById(@PathVariable("id") Long id) {
        return menuService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Menu> menuList) {
        menuService.saveAll(menuList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        log.info("Delete all menus: ");
        menuService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("Delte menu by id :" + id);
        menuService.deleteById(id);
    }

    @RequestMapping("/{id}/items/")
    public List<MenuItem> getItems(@PathVariable("id") Long id) {
        Optional<Menu> menu = menuService.findById(id);
        if (menu == null)
            return null;
        return menuItemRepository.findByMenu_Id(id);
    }

    @PostMapping("/{id}/items/")
    public void addItems(@PathVariable("id") Long id,@RequestBody List<MenuItem> items) {
        Optional<Menu> menu = menuService.findById(id);
        if (menu == null)
            return ;

        for (MenuItem item : items)
            item.setMenu(menu.get());

        menuItemRepository.saveAll(items);
    }
}
