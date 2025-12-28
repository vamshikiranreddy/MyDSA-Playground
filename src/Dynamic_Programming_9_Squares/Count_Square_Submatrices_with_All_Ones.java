package Dynamic_Programming_9_Squares;

import java.util.*;

public class Count_Square_Submatrices_with_All_Ones {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		int memoAns = Count_Square_Submatrices_with_All_OnesMemo(matrix);
		System.out.println("Memoization Result : " + memoAns);

		int tabuAns = Count_Square_Submatrices_with_All_OnesTab(matrix);
		System.out.println("Tabulation Result : " + tabuAns);

	}

	private static int Count_Square_Submatrices_with_All_OnesTab(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] Dp = new int[m][n];
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						Dp[i][j] = 1;
					} else {
						int left = Dp[i][j - 1];
						int top = Dp[i - 1][j];
						int topleft = Dp[i - 1][j - 1];

						Dp[i][j] = Math.min(left, Math.min(top, topleft)) + 1;
					}
					count += Dp[i][j];
				}
			}
		}
		return count;
	}

	private static int Count_Square_Submatrices_with_All_OnesMemo(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] Dp = new int[m][n];
		for (int[] row : Dp)
			Arrays.fill(row, -1);
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					count += recursion(i, j, matrix, Dp, count);
				}
			}
		}
		return count;
	}

	public static int recursion(int i, int j, char[][] matrix, int[][] Dp, int count) {
		if (i < 0 || j < 0)
			return 0;
		if (matrix[i][j] == '0')
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];

		int left = recursion(i, j - 1, matrix, Dp, count);
		int top = recursion(i - 1, j, matrix, Dp, count);
		int topleft = recursion(i - 1, j - 1, matrix, Dp, count);

		return Dp[i][j] = Math.min(left, Math.min(top, topleft)) + 1;
	}

}
