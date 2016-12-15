package com.selfPractice.design.poker;

public class Card {

	private CardSuitEnum cardSuit;
	private CardRankEnum cardRank;

	public Card(CardRankEnum rank, CardSuitEnum suit) {
		if (rank.getValue() > 14 || rank.getValue() < 2) {
			cardRank = CardRankEnum.TWO;
		} else {
			cardRank = rank;
		}

		if (suit.getValue() > 4 || suit.getValue() < 1) {
			cardSuit = CardSuitEnum.SPADE;
		} else {
			cardSuit = suit;
		}
	}

	public void setCardSuit(CardSuitEnum newSuit) {
		if (newSuit.getValue() >= 1 && newSuit.getValue() <= 4) {
			cardSuit = newSuit;
		} else {
			cardSuit = CardSuitEnum.SPADE;
		}
	}

	public void setCardRank(CardRankEnum newRank) {
		if (newRank.getValue() >= 2 && newRank.getValue() <= 14) {
			cardRank = newRank;
		} else {
			cardRank = CardRankEnum.TWO;
		}
	}

	public boolean isGreater(Card c) {
		if (this.getCardRank().getValue() > c.getCardRank().getValue() || (this.getCardRank() == c.getCardRank() && this.getCardSuit().getValue() > c.getCardSuit().getValue())) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		int rank = this.getCardRank().getValue();
		int suit = this.getCardSuit().getValue();

		switch (rank) {
			case 14:
				result.append(CardRankEnum.ACE);
				break;
			case 13:
				result.append(CardRankEnum.KING);
				break;
			case 12:
				result.append(CardRankEnum.QUEEN);
				break;
			case 11:
				result.append(CardRankEnum.JACK);
				break;
			case 10:
				result.append(CardRankEnum.TEN);
				break;
			case 9:
				result.append(CardRankEnum.NINE);
				break;
			case 8:
				result.append(CardRankEnum.EIGHT);
				break;
			case 7:
				result.append(CardRankEnum.SEVEN);
				break;
			case 6:
				result.append(CardRankEnum.SIX);
				break;
			case 5:
				result.append(CardRankEnum.FIVE);
				break;
			case 4:
				result.append(CardRankEnum.FOUR);
				break;
			case 3:
				result.append(CardRankEnum.THREE);
				break;
			case 2:
				result.append(CardRankEnum.TWO);
				break;
			default:
				result.append(cardRank).append(" ");
			}
			result.append(" of ");
			switch (suit) {
			case 1:
				result.append(CardSuitEnum.CLUB);
				break;
			case 2:
				result.append(CardSuitEnum.DIAMOND);
				break;
			case 3:
				result.append(CardSuitEnum.HEART);
				break;
			case 4:
				result.append(CardSuitEnum.SPADE);
				break;
		}

		return result.toString();
	}

	public CardSuitEnum getCardSuit() {
		return cardSuit;
	}

	public CardRankEnum getCardRank() {
		return cardRank;
	}
}
