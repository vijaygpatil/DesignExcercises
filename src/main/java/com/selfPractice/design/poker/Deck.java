package com.selfPractice.design.poker;

import java.util.Random;

public class Deck {
	private Card[] deck;
	private int top;

	public void createNewSortedDeck() {
		int count = 0;
		deck = new Card[52];
		for (CardRankEnum rank : CardRankEnum.values()) {
			for (CardSuitEnum suit : CardSuitEnum.values()) {
				deck[count] = new Card(rank, suit);
				count++;
			}
		}
		top = 0;
	}

	public Card getACardFromDeck() {
		Card card = deck[top];
		top = top + 1;
		if (top == 52) {
			this.shuffleDeck();
		}
		return card;
	}

	public void shuffleDeck() {
		int swapIndex;
		Card temp;
		Random random = new Random();
		for (int i = 0; i < deck.length; i++) {
			swapIndex = random.nextInt(deck.length - i) + i;
			temp = deck[swapIndex];
			deck[swapIndex] = deck[i];
			deck[i] = temp;
		}
		top = 0;
	}
}
