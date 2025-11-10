 package Dynamic_Programming_2;

import java.util.*;

public class Minimum_Path_Sum {
	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		int memoResult = Memoization(grid);
		int tabuResult = Tabulation(grid);

		System.out.println("Minimum Path Sum Using Memoization : " + memoResult);
		System.out.println("Minimum Path Sum Using Tabulation  : " + tabuResult);
	}

	private static int Tabulation(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] Dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					Dp[i][j] = grid[i][j];
				else {
					int down = (i > 0) ? grid[i][j] + Dp[i - 1][j] : (int) 1e9;
					int right = (j > 0) ? grid[i][j] + Dp[i][j - 1] : (int) 1e9;
					Dp[i][j] = Math.min(down, right);
				}
			}
		}
		return Dp[m - 1][n - 1];
	}

	private static int Memoization(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] Dp = new int[m][n];
		for (int[] row : Dp) {
			Arrays.fill(row, -1);
		}
		return Solver(m - 1, n - 1, grid, Dp);
	}

	private static int Solver(int i, int j, int[][] grid, int[][] Dp) {
		if (i == 0 && j == 0)
			return grid[0][0];
		if (i < 0 || j < 0)
			return (int) 1e9;
		if (Dp[i][j] != -1)
			return Dp[i][j];

		int up = grid[i][j] + Solver(i - 1, j, grid, Dp);
		int left = grid[i][j] + Solver(i, j - 1, grid, Dp);

		return Dp[i][j] = Math.min(up, left);
	}

}
