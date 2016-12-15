package com.selfPractice.design.vending;

import java.util.List;

/**
 * The public API of vending machine, usually all high-level functionality
 * should go in this class
 * 
 * @author patil
 *
 */
public interface VendingMachine {
	public long selectItemAndGetPrice(Item item);

	public void insertCoin(Coin coin);

	public List<Coin> refund();

	public Bucket<Item, List<Coin>> collectItemAndChange();

	public void reset();
}