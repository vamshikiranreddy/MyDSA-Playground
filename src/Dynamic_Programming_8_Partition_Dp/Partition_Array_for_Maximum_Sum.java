package Dynamic_Programming_8_Partition_Dp;

import java.util.*;

public class Partition_Array_for_Maximum_Sum {

	public static void main(String[] args) {

		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;

		int memoAns = maxSumAfterPartitioningMemo(arr, k);
		System.out.println("Memoization Result : " + memoAns);

		int tabuAns = maxSumAfterPartitioningTab(arr, k);
		System.out.println("Tabulation Result : " + tabuAns);

	}

	private static int maxSumAfterPartitioningTab(int[] arr, int k) {
		int n = arr.length;
		int[] Dp = new int[n + 1];
		// No BASE CASE
		for (int idx = n - 1; idx >= 0; idx--) {
			int maxSum = Integer.MIN_VALUE;
			int maxEle = Integer.MIN_VALUE;
			int len = 0;
			for (int j = idx; j < Math.min(n, idx + k); j++) {
				len++;
				maxEle = Math.max(maxEle, arr[j]);
				int sum = (len * maxEle) + Dp[j + 1];
				maxSum = Math.max(sum, maxSum);
			}
			Dp[idx] = maxSum;
		}
		return Dp[0];
	}

	private static int maxSumAfterPartitioningMemo(int[] arr, int k) {
		int n = arr.length;
		int[] Dp = new int[n + 1];
		Arrays.fill(Dp, -1);
		return recursion(0, arr, k, n, Dp);
	}

	public static int recursion(int idx, int[] arr, int k, int n, int[] Dp) {
		if (idx == n)
			return 0;
		if (Dp[idx] != -1)
			return Dp[idx];
		int maxSum = Integer.MIN_VALUE;
		int maxEle = Integer.MIN_VALUE;
		int len = 0;
		for (int j = idx; j < Math.min(n, idx + k); j++) {
			len++;
			maxEle = Math.max(maxEle, arr[j]);
			int sum = (len * maxEle) + recursion(j + 1, arr, k, n, Dp);
			maxSum = Math.max(sum, maxSum);
		}
		return Dp[idx] = maxSum;
	}
}
