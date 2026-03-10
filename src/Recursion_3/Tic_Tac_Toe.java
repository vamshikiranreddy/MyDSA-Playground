package Recursion_3;

import java.util.*;

public class Tic_Tac_Toe {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[][] board = { { 'X', 'O', 'X' }, { 'O', 'X', '_' }, { '_', 'O', '_' } };

		int[] ans = solver(board);

		System.out.println(ans[0] + "," + ans[1]);
	}

	public static int[] solver(char[][] board) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (board[i][j] == '_') {

					board[i][j] = 'X';

					if (checkWin(board, 'X')) {
						return new int[] { i, j };
					}

					board[i][j] = '_';
				}
			}
		}

		return new int[] { -1, -1 };
	}

	public static boolean checkWin(char[][] board, char player) {

		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
				return true;
		}

		for (int j = 0; j < 3; j++) {
			if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
				return true;
		}

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
			return true;

		if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
			return true;

		return false;
	}
}