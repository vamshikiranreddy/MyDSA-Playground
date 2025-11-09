package BackTracking;

import java.util.*;

public class Count_SubSet_Sum_Equals_K {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		int K = 3;
		int count = SubsequenceSum(arr, K);
		System.out.println(count);
	}

	private static int SubsequenceSum(int[] arr, int k) {
		return recursion(0, arr, k, 0, 0);
	}

	private static int recursion(int idx, int[] arr, int k, int count, int sum) {
		if (idx == arr.length) {
			if (sum == k) {
				return 1;
			}
			return 0;
		}
		// Include
		sum = sum + arr[idx];
		int include = recursion(idx + 1, arr, k, count, sum);
		sum = sum - arr[idx];

		int exclude = recursion(idx + 1, arr, k, count, sum);
		return include + exclude;

	}

}
