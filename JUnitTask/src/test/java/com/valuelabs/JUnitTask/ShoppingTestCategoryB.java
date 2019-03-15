package com.valuelabs.JUnitTask;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ ShoppingSlowTests.class, ShoppingFastTests.class })
public class ShoppingTestCategoryB {
    @Test(expected = WrongInputException.class)
    public void testWrongInput() throws Exception {
    	ShoppingCart cart = new ShoppingCart();
		try {
		cart.addNewProduct("hello", -100);
		}
		catch(WrongInputException e)
		{
			assertEquals("Error!","Wrong input!",e.getMessage());
			throw e;
		}
	}
}