package com.swageat.dos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.swageat.constants.Category;
import com.swageat.constants.DishType;

import lombok.Data;
@Data
public class MenuItem extends BaseDO {

	protected String name;
	protected String description;
	@Enumerated(EnumType.STRING)
	protected DishType type;
	protected double price;
	@Enumerated(EnumType.STRING)
	protected Category category;
	protected boolean isAvailable;
	@OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	protected List<Rating> ratings;
	protected double avgRating;
	protected String imageUrl;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
}