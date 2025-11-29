package Dynamic_Programming_4;

import java.util.*;

public class Unbound_KnapSack {
	public static void main(String[] args) {
		int[] wt = { 2, 3, 4, 7 };
		int[] val = { 5, 8, 9, 17 };
		int W = 10;

		System.out.println("Memoization Result : " + unboundedKnapMemo(wt, val, W));
		System.out.println("Tabulization Result : " + unboundedKnapTab(wt, val, W));
		System.out.println("Space Optimized Result : " + unboundedKnapOpt(wt, val, W));
	}

	private static int unboundedKnapOpt(int[] wt, int[] val, int W) {
		int n = wt.length;
		int[] prev = new int[W + 1];
		for (int w = 0; w <= W; w++) {
			if (wt[0] <= W)
				prev[w] = (w / wt[0]) * val[0];
			else
				prev[w] = -(int) 1e9;
		}
		for (int idx = 1; idx < n; idx++) {
			int[] curr = new int[W + 1];
			for (int w = 1; w <= W; w++) {
				int nottake = prev[w];
				int take = -(int) 1e9;
				if (wt[idx] <= w) {
					take = val[idx] + curr[w - wt[idx]];
				}
				curr[w] = Math.max(nottake, take);
			}
			prev = curr;
		}
		return prev[W];
	}

	private static int unboundedKnapTab(int[] wt, int[] val, int W) {
		int n = wt.length;
		int[][] Dp = new int[n][W + 1];
		for (int w = 0; w <= W; w++) {
			if (wt[0] <= W)
				Dp[0][w] = (w / wt[0]) * val[0];
			else
				Dp[0][w] = -(int) 1e9;
		}
		for (int idx = 1; idx < n; idx++) {
			for (int w = 1; w <= W; w++) {
				int nottake = Dp[idx - 1][w];
				int take = -(int) 1e9;
				if (wt[idx] <= w) {
					take = val[idx] + Dp[idx][w - wt[idx]];
				}
				Dp[idx][w] = Math.max(nottake, take);
			}
		}
		return Dp[n - 1][W];
	}

	private static int unboundedKnapMemo(int[] wt, int[] val, int w) {
		int n = wt.length;
		int[][] Dp = new int[n][w + 1];
		for (int[] rows : Dp)
			Arrays.fill(rows, -1);
		return recursion(n - 1, w, wt, val, Dp);
	}

	private static int recursion(int idx, int W, int[] wt, int[] val, int[][] Dp) {
		if (idx == 0) {
			if (wt[idx] <= W)
				return (W / wt[idx]) * val[idx];
			else
				return -(int) 1e9;
		}
		if (Dp[idx][W] != -1)
			return Dp[idx][W];
		int nottake = recursion(idx - 1, W, wt, val, Dp);
		int take = -(int) 1e9;
		if (wt[idx] <= W) {
			take = val[idx] + recursion(idx, W - wt[idx], wt, val, Dp);
		}
		return Dp[idx][W] = Math.max(nottake, take);
	}
}
