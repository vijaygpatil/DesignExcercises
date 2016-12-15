package com.selfPractice.design.poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayPoker {
	public static void main(String[] args) {
		int totalPoints = 10000;
		boolean playMore = true;

		System.out.println("WELCOME TO THE POKER GAME!!");
		System.out.println("You have a total balance of 10000 Dollars.");

		Deck deck = new Deck();
		deck.createNewSortedDeck();
		deck.shuffleDeck();

		do {
			if (totalPoints <= 0) {
				System.out.println("YOU DO NOT HAVE ENOUGH BALANCE TO PLAY ANY MORE.");
				playMore = false;
				System.exit(0);
			}

			System.out.print("Do you want to proceed? Type YES or NO: ");

			String playOrNot = null;
			try {
				BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
				playOrNot = is.readLine();
			} catch (IOException e) {
				System.err.println("Unexpected IO ERROR: " + e);
			}

			if (!(playOrNot.equals("YES") || playOrNot.equals("NO"))) {
				System.out.println("Please type YES or NO.");
				continue;
			}

			if (playOrNot.equals("YES")) {
				playMore = true;
				System.out.print("Enter the amount of money you want to bet: ");
				String line = null;
				int val = 0;

				do {
					try {
						BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
						line = is.readLine();
						val = Integer.parseInt(line);
					} catch (NumberFormatException ex) {
						System.err.println("YOU ENTERED A INVALID NUMBER: " + line);
					} catch (IOException e) {
						System.err.println("IO ERROR: " + e);
					}
					if (val > totalPoints) {
						System.out.println("You do not have enough balance! ");
						System.out.println("You have a current balance of: " + totalPoints + " Dollars");
						System.out.print("Please enter bet lower than your current balance: ");
					}
				} while (val > totalPoints);

				System.out.println("You Entered: " + val + " Dollars");
				System.out.println("This is your poker hand: ");
				System.out.println("============================");

				Hand hand = new Hand(deck.getACardFromDeck(), deck.getACardFromDeck(), deck.getACardFromDeck(), deck.getACardFromDeck(), deck.getACardFromDeck());

				System.out.print(hand.gameToString());
				System.out.println("============================");

				System.out.println("You may draw up to 3 cards!");
				int draw = 3;

				for (int i = 0; i <= draw - 1;) {
					System.out.print("Enter the card you would like to draw (Enter 1 - 5 for the cards, or 0 to stop drawing):");
					int drawVal = 0;
					try {
						BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
						line = is.readLine();
						drawVal = Integer.parseInt(line);
						i++;
					} catch (NumberFormatException ex) {
						System.err.println("YOU ENTERED A INVALID NUMBER: " + line);
					} catch (IOException e) {
						System.err.println("IO ERROR: " + e);
					}

					if (drawVal == 0) {
						break;
					}

					hand.draw(drawVal - 1, deck.getACardFromDeck());
				}

				System.out.println("Your hand is now: ");
				System.out.println("============================");
				System.out.print(hand.gameToString());
				System.out.println("============================");
				System.out.print("This hand is: ");
				System.out.print(hand.toString());

				if (hand.hasGoodPair()) {
					System.out.println("You won your bet! Its a good Pair. You dont loose anything!!");
					totalPoints = totalPoints + 0;
					System.out.println("You now have " + totalPoints + " Points!");
				} else {
					switch (hand.getCardRank()) {
						case 0:
							System.out.println("HA! HA! You are a loser. Wear your loser hat!");
							totalPoints = totalPoints - val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 1:
							System.out.println("HA! HA! You are a loser. Wear your loser hat!");
							totalPoints = totalPoints - val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 2:
							System.out.println("GOOD JOB! You won 2 times your bet!");
							totalPoints = totalPoints + 2 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 3:
							System.out.println("GOOD JOB! You won 4 times your bet!");
							totalPoints = totalPoints + 4 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 4:
							System.out.println("GOOD JOB! You won 5 times your bet!");
							totalPoints = totalPoints + 5 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 5:
							System.out.println("GOOD JOB! You won 8 times your bet!");
							totalPoints = totalPoints + 8 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 6:
							System.out.println("GOOD JOB! You won 10 times your bet!");
							totalPoints = totalPoints + 10 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 7:
							System.out.println("GOOD JOB! You won 15 times your bet!");
							totalPoints = totalPoints + 15 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 8:
							System.out.println("GOOD JOB! You won 25 times your bet!");
							totalPoints = totalPoints + 25 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						case 9:
							System.out.println("GOOD JOB! You won 100 times your bet!");
							totalPoints = totalPoints + 100 * val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
						default:
							System.out.println("HA! HA! You are a loser. Wear your loser hat!");
							totalPoints = totalPoints - val;
							System.out.println("You now have " + totalPoints + " Dollars!");
							break;
					}
				}
			} else {
				playMore = false;
				System.out.println("Thank you for playing! GOOD BYE!!");
			}
		} while (playMore);
	}
}
