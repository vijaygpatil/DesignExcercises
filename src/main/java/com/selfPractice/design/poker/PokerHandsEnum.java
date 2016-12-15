package com.selfPractice.design.poker;

public enum PokerHandsEnum {
	BUST("Bust"), ONE_PAIR("One Pair"), TWO_PAIR("Two Pair"), THREE_OF_A_KIND("Three of a Kind"), STRAIGHT("Straight"), FLUSH("Flush"), FULL_HOUSE("Full House"), FOUR_OF_A_KIND("Four of a Kind"), STRAIGHT_FLUSH("Straight Flush"), ROYAL_FLUSH("Royal Flush");

	private String value;

	private PokerHandsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
