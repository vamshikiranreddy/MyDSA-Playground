package Dynamic_Programming;

import java.util.*;

public class House_Robber {
	static class Solution {
		static int[] DP;

		int findMaxSum_Memo(int[] arr) {
			int n = arr.length;
			DP = new int[n];
			Arrays.fill(DP, -1);
			return Solver(n - 1, arr);
		}

		int Solver(int idx, int[] arr) {
			if (idx == 0)
				return arr[0];
			if (idx < 0)
				return 0;
			if (DP[idx] != -1)
				return DP[idx];
			int Pick = arr[idx] + Solver(idx - 2, arr);
			int notPick = Solver(idx - 1, arr);
			return DP[idx] = Math.max(Pick, notPick);
		}

		public int findMaxSum_Tabu(int[] arr) {
			int n = arr.length;
			int[] Dp = new int[n];
			if (n == 1)
				return arr[0];
			Dp[0] = arr[0];
			Dp[1] = Math.max(arr[0], arr[1]);
			for (int i = 2; i < n; i++) {
				int pick = arr[i] + Dp[i - 2];
				int notpick = Dp[i - 1];
				Dp[i] = Math.max(pick, notpick);
			}
			return Dp[n - 1];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 9 };

		Solution obj = new Solution();

		int ansMemo = obj.findMaxSum_Memo(arr);
		int ansTabu = obj.findMaxSum_Tabu(arr);

		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Maximum sum using Memoization: " + ansMemo);
		System.out.println("Maximum sum using Tabulation: " + ansTabu);
	}

}
