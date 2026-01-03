package Sliding_Window_2;

import java.util.*;

public class BinarySubarray_Sum {

	public static void main(String[] args) {
		int[] nums = { 1, 0, 1, 0, 1 };
		int goal = 2;

		int bruteAns = numSubarraysWithSumBrute(nums, goal);
		int optAns = numSubarraysWithSumOptimal(nums, goal);

		System.out.println("Brute Force Answer: " + bruteAns);
		System.out.println("Optimal Answer: " + optAns);

	}

	private static int numSubarraysWithSumOptimal(int[] nums, int goal) {
		int SumTillGoal = function(nums, goal);
		int SumLessThanGoal = function(nums, goal - 1);
		return SumTillGoal - SumLessThanGoal;
	}

	private static int function(int[] nums, int goal) {
		if (goal < 0)
			return 0;
		int n = nums.length;
		int left = 0, right = 0;
		int count = 0, sum = 0;
		while (right < n) {
			sum += nums[right];
			while (sum > goal) {
				sum -= nums[left];
				left++;
			}
			count += right - left + 1;
			right++;
		}
		return count;
	}

	private static int numSubarraysWithSumBrute(int[] nums, int goal) {
		int n = nums.length, count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				if (sum == goal)
					count++;
			}
		}
		return count;
	}

}
