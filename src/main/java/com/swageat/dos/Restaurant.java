package com.swageat.dos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class Restaurant extends BaseDO {

	protected String name;
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	protected List<Rating> rating;
	protected double avgRating;
	protected boolean isRecommended;
	protected boolean isCurrentlyDelivering;
	protected List<MenuItem> bestSellers;
	@JsonManagedReference
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Menu> menus;
}
