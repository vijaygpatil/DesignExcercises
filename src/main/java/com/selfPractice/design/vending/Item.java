package com.selfPractice.design.vending;

/**
 * Java Enum to represent Item served by Vending Machine
 * 
 * @author patil
 *
 */
public enum Item {
	COKE("Coke", 25), PEPSI("Pepsi", 35), SODA("Soda", 45);
	private String name;
	private int price;

	private Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}
}