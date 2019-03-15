package com.valuelabs.JUnitTask;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ 
	ShoppingCartParameterTest.class, 
	ShoppingCartTest.class,
	ShoppingCartFastTest.class,
	ShoppingCartFastTestOnly.class,
	ShoppingCartSlowTest.class,
	ShoppingCartSlowTestOnly.class
	})

public class ShoppingCartAllTests {

}
