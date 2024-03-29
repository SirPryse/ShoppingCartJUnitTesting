package com.valuelabs.JUnitTask;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(ShoppingSlowTests.class)
@ExcludeCategory(ShoppingFastTests.class)
@SuiteClasses({ ShoppingTestCategoryA.class, ShoppingTestCategoryB.class })
public class ShoppingCartSlowTestOnly {
    
}