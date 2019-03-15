package com.valuelabs.JUnitTask;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class ShoppingCartTest {

	ShoppingCart cart;

	@Before
	public void setUp() {
		cart = new ShoppingCart();
	}
	
	@Rule
	public ShoppingCartRule shoppingRule = new ShoppingCartRule();

	@Rule
	public final TestRule globalTimeout = Timeout.millis(20);


	@Test
	public void testAddProducts() throws WrongInputException {

		cart.addNewProduct("Cheetos", 200);
		assertEquals("The output is wrong!", 1, cart.getItemNumber());
		assertEquals("The output is wrong!", 200, cart.getSum());
	}
	
	@Test
	public void testException() throws ProductNotFoundException {
		try {
			cart.removeProduct("Cheetos");
		} catch (ProductNotFoundException e) {
			assertEquals("Error!", "The are no products!", e.getMessage());
		}
	}
	
	@Test(expected = WrongInputException.class)
	public void testWrongInput() throws Exception {
		try {
		cart.addNewProduct("hello", -100);
		}
		catch(WrongInputException e)
		{
			assertEquals("Error!","Wrong input!",e.getMessage());
			throw e;
		}
	}
	
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
	
	@Test
	public void clearTest() {
		cart.clearCart();
		assertEquals("Error clearing cart!", 0, cart.getSum());
		assertEquals("Error clearing cart!", 0, cart.getItemNumber());
	}
}
