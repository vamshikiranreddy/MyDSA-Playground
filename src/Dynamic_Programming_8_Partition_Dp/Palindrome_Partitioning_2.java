package Dynamic_Programming_8_Partition_Dp;

import java.util.*;

public class Palindrome_Partitioning_2 {

	public static void main(String[] args) {
		String s = "aab";

		int tabAns = Palindrome_PartitioningTAB(s);
		int memoAns = Palindrome_PartitioningMEMO(s);

		System.out.println("Minimum Cuts (Tabulation): " + tabAns);
		System.out.println("Minimum Cuts (Memoization): " + memoAns);
	}
	public static int Palindrome_PartitioningTAB(String s) {
		int n = s.length();
		int[] Dp = new int[n + 1];

		for (int idx = n - 1; idx >= 0; idx--) {
			int minPartitions = Integer.MAX_VALUE;
			for (int j = idx; j < n; j++) {
				if (isPalindrome(s, idx, j)) {
					int cost = 1 + Dp[j + 1];
					minPartitions = Math.min(minPartitions, cost);
				}
				Dp[idx] = minPartitions;
			}
		}
		return Dp[0] - 1;
	}
	public static int Palindrome_PartitioningMEMO(String s) {
		int n = s.length();
		int[] Dp = new int[n];
		Arrays.fill(Dp, -1);
		return recursion(0, s, Dp) - 1;
	}

	public static int recursion(int idx, String s, int[] Dp) {
		int n = s.length();
		if (idx == n)
			return 0;
		if (Dp[idx] != -1)
			return Dp[idx];

		int minPartitions = Integer.MAX_VALUE;
		for (int j = idx; j < n; j++) {
			;
			if (isPalindrome(s, idx, j)) {
				int cost = 1 + recursion(j + 1, s, Dp);
				minPartitions = Math.min(minPartitions, cost);
			}
		}
		return Dp[idx] = minPartitions;
	}

	public static boolean isPalindrome(String s, int left, int right) {
		while (left <= right) {
			if (s.charAt(left++) != s.charAt(right--))
				return false;
		}
		return true;
	}
}
