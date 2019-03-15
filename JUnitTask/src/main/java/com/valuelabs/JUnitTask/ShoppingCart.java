package com.valuelabs.JUnitTask;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart implements Shopping{

	private int items;
	private Map<String, Integer> productName;
	private int sum;

	ShoppingCart() {
		items = 0;
		sum = 0;
		productName = new ConcurrentHashMap<>();
	}

	public void addNewProduct(String name, int cost) throws WrongInputException {
		if(cost>=1) {
		productName.put(name, cost);
		sum += cost;
		incrementItem();
		}
		else {
			throw new WrongInputException("Wrong input!");
		}
	}

	public void removeProduct(String name) throws ProductNotFoundException {
		int flag = 0;
		if (getItemNumber() == 0) {
			throw new ProductNotFoundException("The are no products!");
		}
		
		/*
		 * productName.forEach((k,v) -> { if(name.equals(k)) { sum = sum - v;
		 * productName.remove(k); decrementItem(); //flag=1;} } );
		 */

		
		Iterator<Map.Entry<String, Integer>> product = productName.entrySet().iterator();

		while (product.hasNext()) {
			Map.Entry<String, Integer> entry = product.next();
			if (name.equals(entry.getKey())) {
				sum = sum - entry.getValue();
				productName.remove(entry.getKey());
				decrementItem();
				flag = 1;
			}
		}

		if (flag == 0) {
			throw new ProductNotFoundException("The product is not found!");
		}
	}
	
	public void clearCart() {
		System.out.println("Shopping Cart Cleared");
		this.productName = new ConcurrentHashMap<>();
		this.items = 0;
		this.sum = 0;
	}
	
	public void incrementItem() {
		this.items++;
	}

	public void decrementItem() {
		this.items--;
	}

	public int getItemNumber() {
		return this.items;
	}

	public int getSum() {
		return this.sum;
	}
}
