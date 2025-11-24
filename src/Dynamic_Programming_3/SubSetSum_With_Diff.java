package Dynamic_Programming_3;

import java.util.*;

public class SubSetSum_With_Diff {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3 };
		int diff = 1;

		System.out.println("Memoization: " + countPartitionsMemo(arr, diff));
		System.out.println("Tabulation: " + countPartitionsTab(arr, diff));
	}

	private static int countPartitionsTab(int[] arr, int diff) {
		int n = arr.length;
		int totalSum = 0;
		for (int num : arr)
			totalSum += num;
		if ((totalSum + diff) % 2 == 1)
			return 1;
		int target = (totalSum + diff) / 2;
		int[][] Dp = new int[n][target + 1];
		if (arr[0] == 0) {
			Dp[0][0] = 2; // take or not take if 0;
		} else {
			Dp[0][0] = 1;
		}
		if (arr[0] != 0 && arr[0] <= target)
			Dp[0][arr[0]] = 1;
		for (int i = 1; i < n; i++) {
			for (int t = 1; t <= target; t++) {
				int nottake = Dp[i-1][t];
				int take = 0;
				if(arr[i] <= t) {
					take = Dp[i - 1][t - arr[i]];
				}
				Dp[i][t] = take + nottake;
			}
		}
		return Dp[n - 1][target];
	}

	private static int countPartitionsMemo(int[] arr, int diff) {
		int n = arr.length;
		int totalSum = 0;
		for (int num : arr)
			totalSum += num;
		if ((totalSum + diff) % 2 == 1)
			return 0;
		int target = (totalSum + diff) / 2;
		int[][] Dp = new int[n][target + 1];
		for (int[] rows : Dp)
			Arrays.fill(rows, -1);
		return recursion(n - 1, target, arr, Dp);
	}

	private static int recursion(int idx, int target, int[] arr, int[][] dp) {

		if (idx == 0) {
			// If 0's are present
			if (target == 0 && arr[idx] == 0)
				return 2;
			if (target == 0 || target == arr[idx])
				return 1;
			return 0;
		}
		if (dp[idx][target] != -1)
			return dp[idx][target];
		int nottake = recursion(idx - 1, target, arr, dp);
		int take = 0;
		if (arr[idx] <= target) {
			take = recursion(idx - 1, target - arr[idx], arr, dp);
		}
		return dp[idx][target] = take + nottake;
	}

}
