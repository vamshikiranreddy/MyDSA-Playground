package Dynamic_Programming_2;

import java.util.*;

public class Unique_Paths {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		int T_result = Tabulization(m, n);
		int M_result = Memoization(m, n);
		System.out.println("Unique Paths Using Tabulization : " + T_result);
		System.out.println("Unique Paths Using Memoization : " + M_result);
	}

	static int[][] Dp;

	private static int Memoization(int m, int n) {
		Dp = new int[m][n];
		for (int[] row : Dp) {
			Arrays.fill(row, -1);
		}
		return Solver(m - 1, n - 1);
	}

	private static int Solver(int i, int j) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];
		int up = Solver(i - 1, j);
		int left = Solver(i, j - 1);
		return Dp[i][j] = up + left;
	}

	private static int Tabulization(int m, int n) {
		int Dp[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			Dp[i][0] = 1;
		for (int i = 0; i < n; i++)
			Dp[0][i] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				Dp[i][j] = Dp[i - 1][j] + Dp[i][j - 1];
			}
		}
		return Dp[m - 1][n - 1];
	}

}
