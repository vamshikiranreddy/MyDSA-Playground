package Dynamic_Programming_7;

import java.util.*;

public class Number_of_Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 4, 3, 2, 6, 7, 2 };
		System.out.println("The count of Longest Increasing Subsequences (LIS) is " + findNumberOfLIS(arr));

	}

	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] Dp = new int[n];
		int[] count = new int[n];
		Arrays.fill(Dp, 1);
		Arrays.fill(count, 1);
		int maxlen = 0;
		for (int idx = 0; idx < n; idx++) {
			for (int prev = 0; prev < idx; prev++) {
				if (nums[prev] < nums[idx] && Dp[prev] + 1 > Dp[idx]) {
					Dp[idx] = Dp[prev] + 1;
					count[idx] = count[prev];
				} else if (nums[prev] < nums[idx] && Dp[prev] + 1 == Dp[idx]) {
					count[idx] += count[prev];
				}
			}
			maxlen = Math.max(maxlen, Dp[idx]);
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (Dp[i] == maxlen)
				cnt += count[i];
		}
		return cnt;
	}
}
