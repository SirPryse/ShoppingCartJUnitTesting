package com.valuelabs.JUnitTask;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ShoppingCartParameterTest {
	private ShoppingCart shoppingCart;
	
	@Parameter(0)
	public String prodName;
	@Parameter(1)
	public Integer prodCost;
	@Parameter(2)
	public int prodSum;
	@Parameter(3)
	public int prodItem; 
	
	/*public ShoppingCartParameterTest(String prodName,Integer prodCost,int prodSum,int prodItem) {
		super();
		this.prodName=prodName;
		this.prodCost=prodCost;
		this.prodSum=prodSum;
		this.prodItem=prodItem;
	}*/
	
	
	
	@Before
	public void intitalize() {
		shoppingCart = new ShoppingCart();
	}
	
	@Parameters
	public static Collection<Object[]> input() {
		return Arrays.asList(new Object[][] {{"Cheetos",1000,1000,1},
			{"Cheetos2",2000,2000,1},{"Cheetos3",3000,3000,1}});
	}
	
	@Test
	public void parameterizedTest() throws WrongInputException {
		System.out.println("Sum of products: " + prodSum);
		shoppingCart.addNewProduct(prodName, prodCost);
		assertEquals(prodSum,shoppingCart.getSum());
		assertEquals(prodItem,shoppingCart.getItemNumber());
	}
	
}
