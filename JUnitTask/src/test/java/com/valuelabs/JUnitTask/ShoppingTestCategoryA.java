package com.valuelabs.JUnitTask;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ShoppingTestCategoryA {
	
	private ShoppingCart cart;
	
	@Before
	public void setUp() {
	cart = new ShoppingCart();
	}
	
	 @Category(ShoppingSlowTests.class)
	@Test
	public void testNormalTransaction() throws ProductNotFoundException, WrongInputException {
		cart.addNewProduct("Cheetos", 200);
		assertEquals("The output is wrong!", 1, cart.getItemNumber());
		cart.addNewProduct("Cheat", 230);
		assertEquals("The output is wrong!", 2, cart.getItemNumber());
		cart.addNewProduct("Cheeeer", 300);
		assertEquals("The output is wrong!", 3, cart.getItemNumber());
		assertEquals("The output is wrong!", 730, cart.getSum());
		cart.removeProduct("Cheat");
		assertEquals("The output is wrong!", 2, cart.getItemNumber());
		assertEquals("The output is wrong!", 500, cart.getSum());
		try {
			cart.removeProduct("Something");
		} catch (Exception e) {
			assertEquals("Error!", "The product is not found!", e.getMessage());
		}

	}

    @Category(ShoppingFastTests.class)
    @Test
	public void clearTest() {
		cart.clearCart();
		assertEquals("Error clearing cart!", 0, cart.getSum());
		assertEquals("Error clearing cart!", 0, cart.getItemNumber());
	}
}
