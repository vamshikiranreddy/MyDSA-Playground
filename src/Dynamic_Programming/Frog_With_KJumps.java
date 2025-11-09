package Dynamic_Programming;

import java.util.*;

public class Frog_With_KJumps {
	static int[] Dp;

	public static void main(String[] args) {
		int[] heights = { 10, 30, 40, 50, 20 };
		int k = 3; // frog can jump up to k steps
		int minEnergy = ForgJump(heights, k);
		System.out.println("Minimum energy required: " + minEnergy);
	}

	private static int ForgJump(int[] heights, int k) {
		int n = heights.length;
		Dp = new int[n];
		Arrays.fill(Dp, -1);
		return Solver(n - 1, heights, k);
	}

	private static int Solver(int idx, int[] heights, int k) {
		if (idx == 0)
			return 0;
		if (Dp[idx] != -1)
			return Dp[idx];
		int minEnergy = Integer.MAX_VALUE;
		for (int j = 1; j <= k; j++) {
			if (idx - j >= 0) {
				int Energy = Solver(idx - j, heights, k) + Math.abs(heights[idx] - heights[idx - j]);
				minEnergy = Math.min(minEnergy, Energy);
			}
		}
		return Dp[idx] = minEnergy;
	}

}
