package com.selfPractice.design.poker;

public enum CardSuitEnum {
	SPADE(1), DIAMOND(2), CLUB(3), HEART(4);

	private int value;

	private CardSuitEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
