package com.beverage.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeverageController {

	static Map<String, Beverage> beverageMap = new HashMap<>();
	static Map<String, Double> ingredPriceMap = new HashMap<>();
	private String validationMessage;

	
	//processing order
	public String processOrder(String[] orders) {

		if (validateOrder(orders)) {

			double price = 0.0;

			for (int i = 0; i < orders.length; i++) {

				String[] orderItems = orders[i].split(",");

				String type = orderItems[0];
				
				if (null!= type && !beverageMap.containsKey(type.toUpperCase())) {
					return "Order contains item outside of menu. Please verify.";
					
				}

				Beverage beverage = beverageMap.get(type.toUpperCase());
				List<String> ingreds = beverage.getIngredients();
				

				price = price + beverage.getPrice();

				if (orderItems.length - 1 > ingreds.size() - 1) {
					return "All ingredients cann't be exclued from an Order";
				}

				else {
					for (int j = 1; j < orderItems.length; j++) {
						String excludeIngred = orderItems[j].substring(1);
						if(!ingreds.contains(excludeIngred)) {
							return "Invalid Exclusion ingredient for order "+type;
						}
						price = price - ingredPriceMap.get(excludeIngred);
					}
				}
			}

			return "$" + price;
		} else {
			return validationMessage;
		}

	}
	
	//Validtaing orders
	public boolean validateOrder(String[] orders) {
		if (orders.length == 0) {
			validationMessage = "No Order to process";
			return false;
		}
		for (int i = 0; i < orders.length; i++) {

			if (orders[i] == null || orders[i] == "" || orders[i].isEmpty()) {
				validationMessage = "Each Order must contain an item.Please verify.";
				return false;
			}

			
		}

		return true;
	}
	
	//Loading Beverages details
	static {

		List<String> coffeeIngreds = new ArrayList<>();
		coffeeIngreds.add("coffee");
		coffeeIngreds.add("milk");
		coffeeIngreds.add("sugar");
		coffeeIngreds.add("water");
		Beverage coffee = new Beverage("Coffee", coffeeIngreds, 5.0);

		List<String> chaiIngreds = new ArrayList<>();
		chaiIngreds.add("tea");
		chaiIngreds.add("milk");
		chaiIngreds.add("sugar");
		chaiIngreds.add("water");
		Beverage chai = new Beverage("Chai", chaiIngreds, 4.0);

		List<String> bananaSmoothieIngreds = new ArrayList<>();
		bananaSmoothieIngreds.add("banana");
		bananaSmoothieIngreds.add("milk");
		bananaSmoothieIngreds.add("sugar");
		bananaSmoothieIngreds.add("water");
		Beverage bananaSmoothie = new Beverage("Banana Smoothie", bananaSmoothieIngreds, 6.0);

		List<String> strawberryShakeIngreds = new ArrayList<>();
		strawberryShakeIngreds.add("strawberry");
		strawberryShakeIngreds.add("milk");
		strawberryShakeIngreds.add("sugar");
		strawberryShakeIngreds.add("water");
		Beverage strawberryShake = new Beverage("Strawberry Shake", strawberryShakeIngreds, 5.0);

		List<String> mojitoIngreds = new ArrayList<>();
		mojitoIngreds.add("lemon");
		mojitoIngreds.add("soda");
		mojitoIngreds.add("sugar");
		mojitoIngreds.add("water");
		mojitoIngreds.add("mint");
		Beverage mojito = new Beverage("Mojito", mojitoIngreds, 7.5);

		beverageMap.put("COFFEE", coffee);
		beverageMap.put("CHAI", chai);
		beverageMap.put("BANANA SMOOTHIE", bananaSmoothie);
		beverageMap.put("STRAWBERRY SHAKE", strawberryShake);
		beverageMap.put("MOJITO", mojito);

	}

	//Loading ingredients price
	static {
		ingredPriceMap.put("milk", 1.0);
		ingredPriceMap.put("sugar", 0.5);
		ingredPriceMap.put("soda", 0.5);
		ingredPriceMap.put("mint", 0.5);
		ingredPriceMap.put("water", 0.5);
	}

}
