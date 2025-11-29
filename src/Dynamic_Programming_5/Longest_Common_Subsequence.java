package Dynamic_Programming_5;

import java.util.*;

public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "ace";

		int memoAns = lcsMemo(s1, s2);
		System.out.println("LCS Memo Output: " + memoAns);

		int taboAns = lcsTabo(s1, s2);
		System.out.println("LCS Tabo Output: " + taboAns);

		String lcsString = printLCS(s1, s2);
		System.out.println("LCS String: " + lcsString);

	}

	private static int lcsMemo(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] Dp = new int[m][n];
		for (int[] row : Dp)
			Arrays.fill(row, -1);
		return recursion(m - 1, n - 1, s1, s2, Dp);
	}

	private static int recursion(int i, int j, String s1, String s2, int[][] Dp) {
		if (i < 0 || j < 0)
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];
		int res = 0;
		if (s1.charAt(i) == s2.charAt(j)) { // if Same
			res = 1 + recursion(i - 1, j - 1, s1, s2, Dp);
		} else {
			int opt1 = recursion(i - 1, j, s1, s2, Dp); // Skip char from s1
			int opt2 = recursion(i, j - 1, s1, s2, Dp); // Skip char from s2
			res = Math.max(opt1, opt2);
		}
		return Dp[i][j] = res;
	}

	private static int lcsTabo(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] Dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					Dp[i][j] = 1 + Dp[i - 1][j - 1];
				} else {
					Dp[i][j] = Math.max(Dp[i - 1][j], Dp[i][j - 1]);
				}
			}
		}
		return Dp[m][n];
	}

	private static String printLCS(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] Dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					Dp[i][j] = 1 + Dp[i - 1][j - 1];
				} else {
					Dp[i][j] = Math.max(Dp[i - 1][j], Dp[i][j - 1]);
				}
			}
		}
		int i = s1.length();
		int j = s2.length();
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			} else if (Dp[i - 1][j] > Dp[i][j - 1]) {
				i--;
			} else
				j--;
		}
		return sb.reverse().toString();
	}

}
