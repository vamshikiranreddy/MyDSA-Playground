package Dynamic_Programming_7;

import java.util.*;

public class Longest_Bitonic_subsequence {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 2, 3, 6, 8, 7 };

		int lengthOfLongestBitonicSequence = LongestBitonicSequence(arr);

		System.out.println("The length of the Longest Bitonic Sequence is: " + lengthOfLongestBitonicSequence);
	}

	private static int LongestBitonicSequence(int[] arr) {

		int n = arr.length;
		int[] dp1 = new int[n]; // LIS
		int[] dp2 = new int[n]; // LDS

		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		// LIS (left → right)
		for (int i = 0; i < n; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[i] > arr[prev]) {
					dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
				}
			}
		}

		// LDS (right → left)
		for (int i = n - 1; i >= 0; i--) {
			for (int prev = n - 1; prev > i; prev--) {
				if (arr[i] > arr[prev]) {
					dp2[i] = Math.max(dp2[i], 1 + dp2[prev]);
				}
			}
		}

		int max = 0;

		// Combine LIS + LDS (strict bitonic)
		for (int i = 0; i < n; i++) {
			if (dp1[i] > 1 && dp2[i] > 1) { // 🔑 important
				max = Math.max(max, dp1[i] + dp2[i] - 1);
			}
		}

		return max;
	}
}
