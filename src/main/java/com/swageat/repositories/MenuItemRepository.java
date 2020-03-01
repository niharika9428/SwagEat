package com.swageat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swageat.dos.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByMenu_Id(Long id);
}
