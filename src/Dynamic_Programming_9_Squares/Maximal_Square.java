package Dynamic_Programming_9_Squares;

import java.util.*;

public class Maximal_Square {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		int memoAns = maximalSquareMemo(matrix);
		System.out.println("Memoization Result : " + memoAns);

		int tabuAns = maximalSquareTab(matrix);
		System.out.println("Tabulation Result : " + tabuAns);

	}

	private static int maximalSquareTab(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] Dp = new int[m][n];
		int maxSide = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						Dp[i][j] = 1;
					} else {
						int left = Dp[i][j - 1];
						int top = Dp[i - 1][j];
						int topLeft = Dp[i - 1][j - 1];
						Dp[i][j] = 1 + Math.min(left, Math.min(top, topLeft));
					}
					
				}
				maxSide = Math.max(maxSide, Dp[i][j]);
			}
		}
		return maxSide * maxSide;
	}

	private static int maximalSquareMemo(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] Dp = new int[m][n];
		for (int[] row : Dp)
			Arrays.fill(row, -1);
		int maxSide = 0;
		// for each cell we'r checking for max area so the loop
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				maxSide = Math.max(maxSide, recursion(i, j, matrix, Dp));
			}

		}
		return maxSide * maxSide;
	}

	private static int recursion(int i, int j, char[][] matrix, int[][] Dp) {
		if (i < 0 || j < 0)
			return 0;
		if (matrix[i][j] == '0')
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];

		int left = recursion(i, j - 1, matrix, Dp);
		int top = recursion(i - 1, j, matrix, Dp);
		int topLeft = recursion(i - 1, j - 1, matrix, Dp);
		// Min Of Neighbours
		return Dp[i][j] = 1 + Math.min(top, Math.min(left, topLeft));
	}

}
