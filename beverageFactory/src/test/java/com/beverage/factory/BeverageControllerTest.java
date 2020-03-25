package com.beverage.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BeverageControllerTest {
	
	private BeverageController bevController;
	
	@Before
	public void init() {
		bevController = new BeverageController();
	}
	
	
	
	@Test
	public void testValidateOrderWithoutItem() {
		String[] orders = {"chai","","mojito"};
		boolean result= bevController.validateOrder(orders);
		
		assertEquals(false, result);
		
	}
	
	@Test
	public void testValidateOrderBlank() {
		String[] orders = {};
		boolean result= bevController.validateOrder(orders);		
		assertEquals(false, result);		
	}
	

	
	@Test
	public void testProcessOrder() {
		String[] orders = {"chai","coffee","mojito"};
		String price= bevController.processOrder(orders);
		
		assertEquals("$16.5", price);
		
	}
	
	@Test
	public void testProcessBanana() {
		String[] orders = {"banana Smoothie"};
		String price= bevController.processOrder(orders);
		
		assertEquals("$6.0", price);
		
	}
	
	@Test
	public void testProcessOrderExclusion() {
		String[] orders = {"chai,-milk","mojito,-soda,-mint"};
		String price= bevController.processOrder(orders);
		
		assertEquals("$9.5", price);
		
	}
	
	@Test
	public void testProcessOrderExc() {
		String[] orders = {"chai,-milk,-sugar,-water,-tea"};
		String price= bevController.processOrder(orders);
		
		assertEquals("All ingredients cann't be exclued from an Order", price);
		
	}
	
	@Test
	public void testProcessOrderExc1() {
		String[] orders = {"chai,-soda"};
		String price= bevController.processOrder(orders);
		
		assertEquals("Invalid Exclusion ingredient for order chai", price);
		
	}
	

	
	
}
