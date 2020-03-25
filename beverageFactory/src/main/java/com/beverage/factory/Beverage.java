package com.beverage.factory;

import java.util.List;

public class Beverage {
	
	private String type;
	private List<String> ingredients;
	private double price;
	
	public Beverage(String type, List<String> ingredients, double price) {
		super();
		this.type = type;
		this.ingredients = ingredients;
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
