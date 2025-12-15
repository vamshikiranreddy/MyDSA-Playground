package Dynamic_Programming_7;

import java.util.*;

public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		int[] nums = {4, 10, 4, 3, 8, 9};

		System.out.println("LIS Memo: " + lisMemo(nums));
		System.out.println("LIS Tabulation: " + lisTab(nums));
		System.out.println("LIS Tabulation 2nd method : " + lisTab2(nums));
		System.out.println("LIS Optimized: " + lisOptimized(nums));
		System.out.println("LIS Most Optimized: " + lisOptimizedBinarySearch(nums));

	}

	private static int lisOptimizedBinarySearch(int[] nums) {
		int n = nums.length;
		List<Integer> temp = new ArrayList<>();
		temp.add(nums[0]);
		for(int i = 1;i < n;i++) {
			if(nums[i] > temp.get(temp.size() - 1)) {
				temp.add(nums[i]);
			}else {
				int idx = BinarySearch(temp,nums[i]);
				temp.set(idx,nums[i]);
			}
		}
		return temp.size();
	}

	private static int BinarySearch(List<Integer> temp, int target) {
		int low = 0;
		int high = temp.size() - 1;
		while(low < high) {
			int mid = low + (high - low) / 2;
			if(temp.get(mid) >= target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int lisTab(int[] nums) {
		int n = nums.length;
		int[][] Dp = new int[n + 1][n + 1]; // for -1 adjustment
		// no need for base case as the array is initilized with 0
		for (int idx = n - 1; idx >= 0; idx--) {
			for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {
				int nottake = Dp[idx + 1][prev_idx + 1];
				int take = 0;
				if (prev_idx == -1 || nums[idx] > nums[prev_idx]) {
					take = 1 + Dp[idx + 1][idx + 1];
				}
				Dp[idx][prev_idx + 1] = Math.max(take, nottake);
			}
		}
		return Dp[0][0];
	}

	private static int lisTab2(int[] nums) {
		int n = nums.length;
		int[] Dp = new int[n];
		Arrays.fill(Dp, 1);
		for (int idx = 0; idx < n; idx++) {
			for (int prev_idx = 0; prev_idx < idx; prev_idx++) {
				if (nums[idx] > nums[prev_idx]) {
					Dp[idx] = Math.max(Dp[idx], 1 + Dp[prev_idx]);
				}
			}
		}
		int ans = Arrays.stream(Dp).max().getAsInt();
		return ans;
	}

	private static int lisOptimized(int[] nums) {
		int n = nums.length;
		int[] after = new int[n + 1];
		for (int idx = n - 1; idx >= 0; idx--) {
			int[] curr = new int[n + 1];
			for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {
				int nottake = after[prev_idx + 1];
				int take = 0;
				if (prev_idx == -1 || nums[idx] > nums[prev_idx]) {
					take = 1 + after[idx + 1];
				}
				curr[prev_idx + 1] = Math.max(take, nottake);
			}
			after = curr;
		}
		return after[0];
	}

	private static int lisMemo(int[] nums) {
		int n = nums.length;
		int[][] Dp = new int[n][n + 1];
		for (int[] row : Dp)
			Arrays.fill(row, -1);
		return recursion(0, -1, nums, Dp);
	}

	private static int recursion(int idx, int prev_idx, int[] nums, int[][] Dp) {
		int n = nums.length;
		if (idx == n)
			return 0;
		if (Dp[idx][prev_idx + 1] != -1)
			return Dp[idx][prev_idx + 1];
		int nottake = recursion(idx + 1, prev_idx, nums, Dp);
		int take = 0;
		if (prev_idx == -1 || nums[idx] > nums[prev_idx]) {
			take = 1 + recursion(idx + 1, idx, nums, Dp);
		}
		return Dp[idx][prev_idx + 1] = Math.max(nottake, take);
	}

}
