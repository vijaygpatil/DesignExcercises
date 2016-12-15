package com.selfPractice.design.poker;

public class Hand {
	private Card[] hand;
	private int rank;

	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		hand = new Card[5];
		hand[0] = c1;
		hand[1] = c2;
		hand[2] = c3;
		hand[3] = c4;
		hand[4] = c5;
		evaluateHandRank();
	}

	public int getCardRank() {
		return rank;
	}

	public String gameToString() {
		String result = new String("");
		for (int i = 0; i < hand.length; i++)
			result += "[" + (i + 1) + "] " + hand[i] + "\n";
		return result;
	}

	public void draw(int index, Card c) {
		if (0 <= index && index <= 4) {
			hand[index] = c;
		}
		evaluateHandRank();
	}

	public boolean hasGoodPair() {
		boolean result;
		result = false;
		if (rank == 1) {
			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 5; j++)
					if (hand[i].getCardRank() == hand[j].getCardRank() && hand[i].getCardRank().getValue() > 10)
						result = true;
			}
		}
		return result;
	}

	public String toString() {
		evaluateHandRank();
		StringBuilder result = new StringBuilder();
		switch (rank) {
			case 0:
				result.append(PokerHandsEnum.BUST);
				break;
			case 1:
				result.append(PokerHandsEnum.ONE_PAIR);
				break;
			case 2:
				result.append(PokerHandsEnum.TWO_PAIR);
				break;
			case 3:
				result.append(PokerHandsEnum.THREE_OF_A_KIND);
				break;
			case 4:
				result.append(PokerHandsEnum.STRAIGHT);
				break;
			case 5:
				result.append(PokerHandsEnum.FLUSH);
				break;
			case 6:
				result.append(PokerHandsEnum.FULL_HOUSE);
				break;
			case 7:
				result.append(PokerHandsEnum.FOUR_OF_A_KIND);
				break;
			case 8:
				result.append(PokerHandsEnum.STRAIGHT_FLUSH);
				break;
			case 9:
				result.append(PokerHandsEnum.ROYAL_FLUSH);
				break;
			default:
				result.append(PokerHandsEnum.BUST);
				break;
		}
		result.append(": " + hand[0] + ", " + hand[1] + ", " + hand[2] + ", " + hand[3] + ", " + hand[4] + "\n");
		return result.toString();
	}

	private void evaluateHandRank() {
		Card[] sortedHand = new Card[5];
		for (int i = 0; i < 5; i++) {
			sortedHand[i] = hand[i];
		}

		sort(sortedHand);
		int pairIndex = -1;

		rank = 0;

		for (int i = 0; i < 4; i++) {
			if (sortedHand[i].getCardRank() == sortedHand[i + 1].getCardRank()) {
				pairIndex = i;
				rank = 1;
				i = 4;
			}
		}

		if (rank == 1) {
			for (int i = pairIndex + 2; i < 4; i++) {
				if (sortedHand[i].getCardRank() == sortedHand[i + 1].getCardRank()) {
					rank = 2;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			if (sortedHand[i].getCardRank() == sortedHand[i + 1].getCardRank() && sortedHand[i + 1].getCardRank() == sortedHand[i + 2].getCardRank()) {
				rank = 3;
				if (i == 0 && sortedHand[3].getCardRank() == sortedHand[4].getCardRank() || i == 2 && sortedHand[0].getCardRank() == sortedHand[1].getCardRank()) {
					rank = 6;
				}
			}
		}

		for (int i = 0; i < 2; i++) {
			if (sortedHand[i].getCardRank() == sortedHand[i + 1].getCardRank() && sortedHand[i + 1].getCardRank() == sortedHand[i + 2].getCardRank() && sortedHand[i + 2].getCardRank() == sortedHand[i + 3].getCardRank()) {
				rank = 7;
			}
		}

		if (rank == 0) {
			if ((sortedHand[4].getCardRank().getValue() - sortedHand[0].getCardRank().getValue() == 4) || (sortedHand[3].getCardRank().getValue() - sortedHand[0].getCardRank().getValue() == 3 && sortedHand[4].getCardRank().getValue() == 14 && sortedHand[0].getCardRank().getValue() == 2)) {
				rank = 4;
			}
		}

		boolean flush;
		if (rank == 0 || rank == 4) {
			flush = true;
			for (int i = 0; i < 4; i++) {
				if (sortedHand[i].getCardSuit() != sortedHand[i + 1].getCardSuit()) {
					flush = false;
				}
			}
			if (flush && rank == 4) {
				rank = 8;
			} else if (flush) {
				rank = 5;
			}
		}

		if (rank == 8 && sortedHand[4].getCardRank().getValue() == 14 && sortedHand[0].getCardRank().getValue() == 10) {
			rank = 9;
		}
	}

	private void sort(Card[] a) {
		Card temp;
		int minIndex;
		for (int i = 0; i < a.length; i++) {
			minIndex = i;
			for (int j = i; j < a.length; j++) {

				if (a[minIndex].isGreater(a[j]))
					minIndex = j;
			}

			temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
	}
}
