package com.selfPractice.design.vending;

/**
 * Another Java Enum to represent Coins supported by Vending Machine
 * 
 * @author patil
 *
 */
public enum Coin {
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	private int denomination;

	private Coin(int denomination) {
		this.denomination = denomination;
	}

	public int getDenomination() {
		return denomination;
	}
}