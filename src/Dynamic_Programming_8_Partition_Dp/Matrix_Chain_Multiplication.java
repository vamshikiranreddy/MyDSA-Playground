package Dynamic_Programming_8_Partition_Dp;

import java.util.*;

public class Matrix_Chain_Multiplication {

	public static void main(String[] args) {
		int[] arr = { 40, 20, 30, 10, 30 };

		System.out.println("Memoization Result : " + mcmMemo(arr));
		System.out.println("Tabulation Result : " + mcmTab(arr));
	}

	private static int mcmTab(int[] arr) {
		int n = arr.length;
		int[][] Dp = new int[n][n];

		// Base Case i == j
		for (int i = 1; i < n; i++)
			Dp[i][i] = 0;

		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				int minOperations = (int) 1e9;
				for (int k = i; k < j; k++) {
					int MatrixA = Dp[i][k];
					int MatrixB = Dp[k + 1][j];
					int Cost = arr[i - 1] * arr[k] * arr[j];
					int Operations = MatrixA + MatrixB + Cost;
					minOperations = Math.min(Operations, minOperations);
				}
				Dp[i][j] = minOperations;
			}
			
		}
		return Dp[1][n - 1];
	}

	private static int mcmMemo(int[] arr) {
		int n = arr.length;
		int[][] Dp = new int[n][n];
		for (int[] row : Dp)
			Arrays.fill(row, -1);
		return recursion(1, n - 1, arr, Dp);// if started from i == 0 we can't get exact matreces
	}

	private static int recursion(int i, int j, int[] arr, int[][] Dp) {
		if (i == j)
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];
		int minOperations = (int) 1e9;
		for (int k = i; k < j; k++) {
			int MatrixA = recursion(i, k, arr, Dp);
			int MatrixB = recursion(k + 1, j, arr, Dp);
			int Cost = arr[i - 1] * arr[k] * arr[j];
			int Operations = MatrixA + MatrixB + Cost;
			minOperations = Math.min(Operations, minOperations);
		}
		return Dp[i][j] = minOperations;
	}

}
