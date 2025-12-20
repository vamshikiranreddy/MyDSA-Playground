package Dynamic_Programming_8_Partition_Dp;

import java.util.*;

public class Minimum_Cost_to_Cut_a_Stick {

	public static void main(String[] args) {
		int n = 7;
		int[] cuts = { 1, 3, 4, 5 };

		int memoAns = minCostMemo(n, cuts);
		System.out.println("Memoization Result : " + memoAns);

		int tabAns = minCostTab(n, cuts);
		System.out.println("Tabulation Result : " + tabAns);

	}

	private static int minCostTab(int n, int[] cuts) {
		int c = cuts.length;
		int[] Cuts = new int[c + 2];
		Cuts[0] = 0; // for length calculation
		Cuts[c + 1] = n; // for length calculation
		for (int i = 0; i < c; i++)
			Cuts[i + 1] = cuts[i];
		Arrays.sort(Cuts);
		int[][] Dp = new int[c + 2][c + 2];
		// Base Case Covered as Array initilized to 0

		for (int i = c; i >= 1; i--) {
			for (int j = i; j <= c; j++) {
				int minCost = (int) 1e9;
				for (int k = i; k <= j; k++) {
					int part1 = Dp[i][k - 1];
					int part2 = Dp[k + 1][j];
					int cost = Cuts[j + 1] - Cuts[i - 1];
					int totCost = part1 + part2 + cost;
					minCost = Math.min(totCost, minCost);
				}
				Dp[i][j] = minCost;
			}
		}
		return Dp[1][c];
	}

	private static int minCostMemo(int n, int[] cuts) {
		int c = cuts.length;
		int[] Cuts = new int[c + 2];
		Cuts[0] = 0; // for length calculation
		Cuts[c + 1] = n; // for length calculation
		for (int i = 0; i < c; i++)
			Cuts[i + 1] = cuts[i];
		Arrays.sort(Cuts);
		int[][] Dp = new int[c + 2][c + 2];
		for (int row[] : Dp)
			Arrays.fill(row, -1);
		return recursion(1, c, Cuts, Dp);
	}

	private static int recursion(int i, int j, int[] cuts, int[][] Dp) {
		if (i > j)
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];
		int minCost = (int) 1e9;
		for (int k = i; k <= j; k++) {
			int part1 = recursion(i, k - 1, cuts, Dp);
			int part2 = recursion(k + 1, j, cuts, Dp);
			int cost = cuts[j + 1] - cuts[i - 1];
			int totCost = cost + part1 + part2;
			minCost = Math.min(totCost, minCost);
		}
		return Dp[i][j] = minCost;
	}

}
