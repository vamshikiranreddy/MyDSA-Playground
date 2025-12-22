package Dynamic_Programming_8_Partition_Dp;

import java.util.*;

public class BaloonBurst {

	public static void main(String[] args) {

		int[] nums = { 3, 1, 5, 8 };

		int memoAns = maxCoins(nums);
		System.out.println("Memoization Result : " + memoAns);
		int tabAns = maxCoinsTab(nums);
		System.out.println("Tabulation Result : " + tabAns);
	}

	private static int maxCoinsTab(int[] nums) {
		int n = nums.length;
		int[] baloons = new int[n + 2];
		baloons[0] = 1;
		baloons[n + 1] = 1;
		int idx = 0;
		for (int i = 1; i <= n; i++)
			baloons[i] = nums[idx++];
		int[][] Dp = new int[n + 2][n + 2];
		// the BASE CASE is covered by by 0
		for (int i = n; i >= 1; i--) {
			for (int j = i; j <= n; j++) { // i or one dosent matter
				if (i > j)
					continue;
				int max = Integer.MIN_VALUE;
				for (int k = i; k <= j; k++) {
					int partition1 = Dp[i][k - 1];
					int partition2 = Dp[k + 1][j];
					int cost = baloons[i - 1] * baloons[k] * baloons[j + 1];
					int totalCoins = cost + partition1 + partition2;
					max = Math.max(max, totalCoins);
				}
				Dp[i][j] = max;
			}
		}
		return Dp[1][n];
	}

	public static int maxCoins(int[] nums) {
		int n = nums.length;
		int[] baloons = new int[n + 2];
		baloons[0] = 1;
		baloons[n + 1] = 1;
		int j = 0;
		for (int i = 1; i <= n; i++)
			baloons[i] = nums[j++];
		int[][] Dp = new int[n + 2][n + 2];
		for (int[] row : Dp)
			Arrays.fill(row, -1);
		return recursion(1, n, baloons, Dp);
	}

	public static int recursion(int i, int j, int[] baloons, int[][] Dp) {
		if (i > j)
			return 0;
		if (Dp[i][j] != -1)
			return Dp[i][j];
		int max = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			int partition1 = recursion(i, k - 1, baloons, Dp);
			int partition2 = recursion(k + 1, j, baloons, Dp);
			int cost = baloons[i - 1] * baloons[k] * baloons[j + 1];
			int totalCoins = cost + partition1 + partition2;
			max = Math.max(max, totalCoins);
		}
		return Dp[i][j] = max;
	}

}
