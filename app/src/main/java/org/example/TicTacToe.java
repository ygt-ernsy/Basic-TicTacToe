package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * TicTacToe
 */
public class TicTacToe {
	static int butChosen;
	private Player pl1;
	private Player pl2;
	private int[][] current;
	private ArrayList<Integer> played;
	private int round;
	private boolean ended;
	private Scanner scanner;

	public TicTacToe(Player pl1, Player pl2) {
		butChosen = 0;
		current = new int[3][3];
		played = new ArrayList<>();
		round = 0;
		ended = false;
		scanner = new Scanner(System.in);
		this.pl1 = pl1;
		this.pl2 = pl2;

		// Explicitly setting to 0 (though not strictly necessary for a new int array)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				current[i][j] = 0;
			}
		}
	}

	public void play() {

		System.out.println("Welcome to TicTacToe");
		System.out.println("Player1 is X(1) and starts first,");
		System.out.println("Then Player2 plays and is O(2).");

		while (!ended) {
			boolean valid = false;

			// Player1's turn start
			display();
			System.out.println("Player1's turn.");
			System.out.println("Pick a valid position(1-9): ");

			while (!valid) {
				Integer position = scanner.nextInt();

				// check if the position was already played
				if (played.contains(position) || 0 > position || position > 9) {
					System.out.println("Invalid position.");
				} else {
					pl1.play(1, position, current);
					played.add(position);
					valid = true;
				}
			}

			checkWin();
			// ends the game if won
			if (ended) {
				display();
				break;
			}

			// draw condition
			if (round == 9) {
				System.out.println("Game is a draw!!");
				display();
				break;
			}

			round++;

			display();
			// Player2's turn start
			valid = false;
			System.out.println("Player2's turn.");
			System.out.println("Pick a valid position(1-9): ");

			while (!valid) {
				Integer position = scanner.nextInt();

				// check if the position was already played
				if (played.contains(position) || 0 > position || position > 9) {
					System.out.println("Invalid position.");
				} else {
					pl2.play(2, position, current);
					played.add(position);
					valid = true;
				}

			}

			checkWin();
			// ends the game if won
			if (ended) {
				display();
				break;
			}

			// draw condition
			if (round == 9) {
				System.out.println("Game is a draw!!");
				display();
				break;
			}

			round++;
		}
	}

	public void checkWin() {

		// check horizonatl
		for (int[] row : current) {
			if (row[0] == 0)
				break;

			if (row[1] == row[0] && row[2] == row[0]) {
				ended = true;
				System.out.println(row[0] + " won.");
				return;
			}
		}

		// check vertical
		for (int col = 0; col < 3; col++) {
			if (current[0][col] == 0)
				break;

			if (current[0][col] == current[1][col] && current[0][col] == current[2][col]) {
				ended = true;
				System.out.println(current[0][col] + " won.");
				return;
			}
		}

		// check 1. diogonal
		if (!(current[0][0] == 0)) {
			if (current[1][1] == current[0][0] && current[2][2] == current[0][0]) {
				ended = true;
				System.out.println(current[0][0] + " won.");
			}
		}

		// check 2. diogonal
		if (!(current[2][0] == 0)) {
			if (current[1][1] == current[2][0] && current[0][2] == current[2][0]) {
				ended = true;
				System.out.println(current[2][0] + " won.");
			}
		}
	}

	public void display() {
		for (int[] row : current) {
			System.out.println(Arrays.toString(row));
		}
	}
}
