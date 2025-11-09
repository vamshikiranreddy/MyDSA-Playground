package Strings;

import java.util.*;

public class Shortest_Common_SuperSequence {
	public static String Short_Common(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder result = new StringBuilder();
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				result.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				result.append(str1.charAt(i - 1));
				i--;
			} else {
				result.append(str2.charAt(j - 1));
				j--;
			}
		}

		while (i > 0)
			result.append(str1.charAt(--i));
		while (j > 0)
			result.append(str2.charAt(--j));

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The First String :");
		String str1 = in.nextLine();
		System.out.println("Enter The Second Sttring :");
		String str2 = in.nextLine();
		String result = Short_Common(str1, str2);
		System.out.println("The Shortest common supersequence is  " + result);
		in.close();
	}
}
