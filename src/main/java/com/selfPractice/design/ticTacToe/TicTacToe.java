package com.selfPractice.design.ticTacToe;
import java.util.Scanner;

public class TicTacToe {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		final int SIZE = 3;
		char[][] board = new char[SIZE][SIZE]; // game board

		resetBoard(board); // initialize the board (with ' ' for all cells)

		// First, welcome message and display the board.
		System.out.println("===== WELCOME TO THE TIC-TAC-TOE GAME!! =====\n");
		showBoard(board);

		// Then ask the user which symbol (x or o) he/she wants to play.
		System.out.print("  Which symbol do you want to play, \"x\" or \"o\"? ");
		char userSymbol = sc.next().toLowerCase().charAt(0);
		char compSymbol = (userSymbol == 'x') ? 'o' : 'x';

		// Also ask whether or not the user wants to go first.
		System.out.println();
		System.out.print("  Do you want to go first (y/n)? ");
		char ans = sc.next().toLowerCase().charAt(0);

		int turn; // 0 -- the user, 1 -- the computer
		int remainCount = SIZE * SIZE; // empty cell count

		// THE VERY FIRST MOVE.
		if (ans == 'y') {
			turn = 0;
			userPlay(board, userSymbol); // user puts his/her first tic
		} else {
			turn = 1;
			compPlay(board, compSymbol); // computer puts its first tic
		}
		// Show the board, and decrement the count of remaining cells.
		showBoard(board);
		remainCount--;

		// Play the game until either one wins.
		boolean done = false;
		int winner = -1; // 0 -- the user, 1 -- the computer, -1 -- draw

		while (!done && remainCount > 0) {
			// If there is a winner at this time, set the winner and the done
			// flag to true.
			done = isGameWon(board, turn, userSymbol, compSymbol); // Did the
																	// turn won?

			if (done)
				winner = turn; // the one who made the last move won the game
			else {
				// No winner yet. Find the next turn and play.
				turn = (turn + 1) % 2;

				if (turn == 0)
					userPlay(board, userSymbol);
				else
					compPlay(board, compSymbol);

				// Show the board after one tic, and decrement the rem count.
				showBoard(board);
				remainCount--;
			}
		}

		// Winner is found. Declare the winner.
		if (winner == 0)
			System.out.println("\n** YOU WON.  CONGRATULATIONS!! **");
		else if (winner == 1)
			System.out.println("\n** YOU LOST..  Maybe next time :) **");
		else
			System.out.println("\n** DRAW... **");

	}

	public static void resetBoard(char[][] brd) {
		for (int i = 0; i < brd.length; i++)
			for (int j = 0; j < brd[0].length; j++)
				brd[i][j] = ' ';
	}

	public static void showBoard(char[][] brd) {
		int numRow = brd.length;
		int numCol = brd[0].length;

		System.out.println();

		// First write the column header
		System.out.print("    ");
		for (int i = 0; i < numCol; i++)
			System.out.print(i + "   ");
		System.out.print('\n');

		System.out.println(); // blank line after the header

		// The write the table
		for (int i = 0; i < numRow; i++) {
			System.out.print(i + "  ");
			for (int j = 0; j < numCol; j++) {
				if (j != 0)
					System.out.print("|");
				System.out.print(" " + brd[i][j] + " ");
			}

			System.out.println();

			if (i != (numRow - 1)) {
				// separator line
				System.out.print("   ");
				for (int j = 0; j < numCol; j++) {
					if (j != 0)
						System.out.print("+");
					System.out.print("---");
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void userPlay(char[][] brd, char usym) {
		System.out.print("\nEnter the row and column indices: ");
		int rowIndex = sc.nextInt();
		int colIndex = sc.nextInt();

		while (brd[rowIndex][colIndex] != ' ') {
			System.out.print("\n!! The cell is already taken.\nEnter the row and column indices: ");
			rowIndex = sc.nextInt();
			colIndex = sc.nextInt();
		}

		brd[rowIndex][colIndex] = usym;
	}

	public static void compPlay(char[][] brd, char csym) {
		// Find the first empty cell and put a tic there.
		for (int i = 0; i < brd.length; i++) {
			for (int j = 0; j < brd[0].length; j++) {
				if (brd[i][j] == ' ') { // empty cell
					brd[i][j] = csym;
					return;
				}
			}
		}
	}

	public static boolean isGameWon(char[][] brd, int turn, char usym, char csym) {
		char sym;
		if (turn == 0)
			sym = usym;
		else
			sym = csym;

		int i, j;
		boolean win = false;

		// Check win by a row
		for (i = 0; i < brd.length && !win; i++) {
			for (j = 0; j < brd[0].length; j++) {
				if (brd[i][j] != sym)
					break;
			}
			if (j == brd[0].length)
				win = true;
		}

		// Check win by a column
		for (j = 0; j < brd[0].length && !win; j++) {
			for (i = 0; i < brd.length; i++) {
				if (brd[i][j] != sym)
					break;
			}
			if (i == brd.length)
				win = true;
		}

		// Check win by a diagonal (1)
		if (!win) {
			for (i = 0; i < brd.length; i++) {
				if (brd[i][i] != sym)
					break;
			}
			if (i == brd.length)
				win = true;
		}

		// Check win by a diagonal (2)
		if (!win) {
			for (i = 0; i < brd.length; i++) {
				if (brd[i][brd.length - 1 - i] != sym)
					break;
			}
			if (i == brd.length)
				win = true;
		}

		// Finally return win
		return win;
	}
}