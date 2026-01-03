package Sliding_Window_2;

import java.util.*;

public class Nice_Subarrays {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 1, 1 };
		int k = 3;

		int bruteAns = numberOfSubarraysBrute(nums, k);
		int optAns = numberOfSubarraysOptimal(nums, k);

		System.out.println("Brute Force Answer: " + bruteAns);
		System.out.println("Optimal Answer: " + optAns);
	}

	// Optimal: atMost(k) - atMost(k-1)
	private static int numberOfSubarraysOptimal(int[] nums, int k) {
		return atMost(nums, k) - atMost(nums, k - 1);
	}

	private static int atMost(int[] nums, int k) {
		if (k < 0)
			return 0;

		int left = 0, sum = 0, count = 0;

		for (int right = 0; right < nums.length; right++) {
			// map odd -> 1, even -> 0
			sum += nums[right] % 2;

			while (sum > k) {
				sum -= nums[left] % 2;
				left++;
			}

			count += right - left + 1;
		}
		return count;
	}

	// Brute force
	private static int numberOfSubarraysBrute(int[] nums, int k) {
		int n = nums.length, count = 0;
		for (int i = 0; i < n; i++) {
			int oddCount = 0;
			for (int j = i; j < n; j++) {
				if (nums[j] % 2 == 1)
					oddCount++;
				if (oddCount == k)
					count++;
			}
		}
		return count;
	}
}
