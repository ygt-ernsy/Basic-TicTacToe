package org.example;

import java.util.Scanner;

/**
 * Player
 */
public class Player {
	private int wins;
	// private Scanner scanner;

	public Player() {
		wins = 0;
		// scanner = new Scanner(System.in);
	}

	public void win() {
		this.wins++;
	}

	public void play(int symbol, int position, int[][] board) {
		// while (TicTacToe.butChosen == 0) ;

		// System.out.println("Pick a valid position(1-9): ");
		// TicTacToe.butChosen = scanner.nextInt();

		switch (position) {
			case 1:
				board[0][0] = symbol;
				break;
			case 2:
				board[0][1] = symbol;
				break;
			case 3:
				board[0][2] = symbol;
				break;
			case 4:
				board[1][0] = symbol;
				break;
			case 5:
				board[1][1] = symbol;
				break;
			case 6:
				board[1][2] = symbol;
				break;
			case 7:
				board[2][0] = symbol;
				break;
			case 8:
				board[2][1] = symbol;
				break;
			case 9:
				board[2][2] = symbol;
				break;
		}
	}
}
