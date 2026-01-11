package Sliding_Window_3;

import java.util.*;

public class Subarrays_with_K_Different_Integers {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3 };
		int k = 2;

		int bruteAns = subarraysWithKDistinctBrute(nums, k);
		int optAns = subarraysWithKDistinctOptimal(nums, k);

		System.out.println("Brute Force Answer: " + bruteAns);
		System.out.println("Optimal Answer: " + optAns);

	}

	private static int subarraysWithKDistinctOptimal(int[] nums, int k) {
		int KIntegers = helper(nums, k);
		int lessThanK = helper(nums, k - 1);
		return KIntegers - lessThanK;
	}

	public static int helper(int[] nums, int k) {
		if (k < 0)
			return 0;
		Map<Integer, Integer> freqMap = new HashMap<>();
		int n = nums.length;
		int left = 0, right = 0, count = 0;
		while (right < n) {
			freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
			while (freqMap.size() > k) {
				freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
				if (freqMap.get(nums[left]) == 0) {
					freqMap.remove(nums[left]);
				}
				left++;
			}
			count += right - left + 1;
			right++;
		}
		return count;
	}

	private static int subarraysWithKDistinctBrute(int[] nums, int k) {
		int n = nums.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			java.util.Set<Integer> set = new java.util.HashSet<>();
			for (int j = i; j < n; j++) {
				set.add(nums[j]);
				if (set.size() == k) {
					count++;
				} else if (set.size() > k) {
					break; // no need to extend further
				}
			}
		}
		return count;
	}

}
