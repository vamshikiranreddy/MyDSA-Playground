package Dynamic_Programming;

import java.util.*;

public class Frog_Jump {

	public static void main(String[] args) {
		int[] heights = { 10, 20, 30, 10 };
		int n = heights.length;

		int minEnergy_1 = frogJump_TopDownDP(n, heights);
		System.out.println("Minimum energy required For Top-Down DP : " + minEnergy_1);
		int[] Dp_2 = new int[n];
		Dp_2[0] = 0;
		for(int i = 1;i< n;i++) {
			int left = Dp_2[i - 1] + Math.abs(heights[i-1] - heights[i]);
			int right = Integer.MAX_VALUE;
			if(i > 1) {
				right = Dp_2[i - 2] + Math.abs(heights[i-2] - heights[i]);
			}
			Dp_2[i] = Math.min(left, right);
		}
		int minEnergy_2 = Dp_2[n-1];
		System.out.println("Minimum energy required For Bottoms-Up DP : " + minEnergy_2);
	}

	// Top - Down DP
	static int[] Dp;

	private static int frogJump_TopDownDP(int n, int[] heights) {
		Dp = new int[n];
		Arrays.fill(Dp, -1);
		return MinJumps(n - 1, heights);
	}

	private static int MinJumps(int idx, int[] heights) {
		if (idx == 0)
			return 0;
		if (Dp[idx] != -1)
			return Dp[idx];
		int left = MinJumps(idx - 1, heights) + Math.abs(heights[idx] - heights[idx - 1]);
		int right = Integer.MAX_VALUE;
		if (idx > 1) {
			right = MinJumps(idx - 2, heights) + Math.abs(heights[idx] - heights[idx - 2]);
		}
		return Dp[idx] = Math.min(left, right);
	}

}