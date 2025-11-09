package BackTracking;

public class Sudoku_Solver {

	private static boolean solve(int[][] board) {
		int Rows = board.length;
		int Cols = board[0].length;
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Cols; j++) {
				if (board[i][j] == 0) {
					for (int num = 1; num <= 9; num++) {
						if (isSafe(board, i, j, num)) {
							board[i][j] = num;
							if (solve(board)) { // Fill Other Empty Spaces In Board
								return true;
							}
							board[i][j] = 0; // BackTrack If Not Final Num
						}
					}
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num || board[i][col] == num)
				return false;
		}
		int startRow = row - (row % 3);
		int startCol = col - (col % 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[startRow + i][startCol + j] == num)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] board = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		System.out.println("Intitial Board : -");
		printBoard(board);
		System.out.println();
		System.out.println();
		if (solve(board)) {
			System.out.println("Solved Board : -");
			printBoard(board);
		} else {
			System.out.println("No solution exists.");
		}

	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println("------+-------+-------");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print("| ");
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}
