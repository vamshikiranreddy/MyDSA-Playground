package Dynamic_Programming_2;

import java.util.*;

public class Unique_Paths_Two {
	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0 } };

		int m = grid.length;
		int n = grid[0].length;

		int T_result = Tabulation(grid, m, n);
		int M_result = Memoization(grid, m, n);

		System.out.println("Unique Paths Using Tabulization : " + T_result);
		System.out.println("Unique Paths Using Memoization : " + M_result);
	}

	private static int Tabulation(int[][] grid, int m, int n) {
		int[][] Dp = new int[m][n];

		if (grid[0][0] == 1)
			return 0;
		Dp[0][0] = 1;

		// first column
		for (int i = 1; i < m; i++) {
			if (grid[i][0] == 0 && Dp[i - 1][0] == 1) {
				Dp[i][0] = 1;
			} else {
				Dp[i][0] = 0;
			}
		}
		// first Row
		for (int j = 1; j < n; j++) {
			if (grid[0][j] == 0 && Dp[0][j - 1] == 1) {
				Dp[0][j] = 1;
			} else {
				Dp[0][j] = 0;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] == 1) {
					Dp[i][j] = 0;
				} else {
					Dp[i][j] = Dp[i - 1][j] + Dp[i][j - 1];
				}
			}
		}
		return Dp[m - 1][n - 1];
	}

	private static int Memoization(int[][] grid, int m, int n) {
		int[][] Dp = new int[m][n];
		for (int[] row : Dp) {
			Arrays.fill(row, -1);
		}
		return Solver(m - 1, n - 1, grid, Dp);
	}

	private static int Solver(int i, int j, int[][] grid, int[][] Dp) {
		if ((i >= 0 && j >= 0) && grid[i][j] == 1)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		if (Dp[i][j] != -1)
			return Dp[i][j];

		int up = Solver(i - 1, j, grid, Dp);
		int left = Solver(i, j - 1, grid, Dp);

		return Dp[i][j] = up + left;
	}
}
