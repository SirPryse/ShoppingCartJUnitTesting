package com.valuelabs.JUnitTask;

public interface Shopping  {
	public void addNewProduct(String name, int cost) throws WrongInputException;
	public void removeProduct(String name) throws ProductNotFoundException;
	public void clearCart();
	public void incrementItem();
	public void decrementItem();
	public int getItemNumber();
	public int getSum();
}
