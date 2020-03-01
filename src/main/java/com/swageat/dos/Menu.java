package com.swageat.dos;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.swageat.constants.Category;
import com.swageat.constants.DishType;

import lombok.Data;

@Data
public class Menu extends BaseDO{

	protected int totalItems;
	protected int noOfCategories;
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	protected List<MenuItem> dishes;
	protected Map<Category,List<MenuItem>> categoryWiseDishes;
	protected Map<DishType,List<MenuItem>> dishesBasedOnType;
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
	protected Restaurant restaurant;
	
}
