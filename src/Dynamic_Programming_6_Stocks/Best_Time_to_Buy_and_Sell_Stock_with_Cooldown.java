package Dynamic_Programming_6_Stocks;

import java.util.*;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public static void main(String[] args) {

		int[] prices = { 1, 2, 3, 0, 2 };

		int memoAns = maxProfitMemo(prices);
		System.out.println("Max Profit (Memo): " + memoAns);

		int taboAns = maxProfitTabulation(prices);
		System.out.println("Max Profit (Tabulation): " + taboAns);

		int optAns = maxProfitSpaceOptimized(prices);
		System.out.println("Max Profit (Space Optimized): " + optAns);
	}

	private static int maxProfitSpaceOptimized(int[] prices) {
		int n = prices.length;

		int[] ahead1 = new int[2]; // idx + 1
		int[] ahead2 = new int[2]; // idx + 2

		for (int idx = n - 1; idx >= 0; idx--) {
			int[] curr = new int[2];
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					int take = -prices[idx] + ahead1[0];
					int nottake = ahead1[1];
					curr[buy] = Math.max(nottake, take);
				} else {
					int selling = prices[idx] + ahead2[1]; // cooldown
					int notselling = ahead1[0];
					curr[buy] = Math.max(notselling, selling);
				}
			}
			ahead2 = ahead1;
			ahead1 = curr;
		}
		return ahead1[1];
	}

	private static int maxProfitTabulation(int[] prices) {

		int n = prices.length;
		int[][] Dp = new int[n + 2][2]; // n+2 for cooldown safety

		for (int idx = n - 1; idx >= 0; idx--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					int take = -prices[idx] + Dp[idx + 1][0];
					int nottake = Dp[idx + 1][1];
					Dp[idx][buy] = Math.max(nottake, take);
				} else {
					int selling = prices[idx] + Dp[idx + 2][1]; // cooldown
					int notselling = Dp[idx + 1][0];
					Dp[idx][buy] = Math.max(notselling, selling);
				}
			}
		}
		return Dp[0][1];
	}

	private static int maxProfitMemo(int[] prices) {
		int n = prices.length;
		int[][] Dp = new int[n][2];
		for (int row[] : Dp)
			Arrays.fill(row, -1);
		return recursion(0, 1, prices, Dp);
	}

	private static int recursion(int idx, int buy, int[] prices, int[][] Dp) {
		// buy == 1 (can buy) || buy == 0 (can't buy already own's a stock)
		if (idx >= prices.length)
			return 0;
		if (Dp[idx][buy] != -1)
			return Dp[idx][buy];

		if (buy == 1) {
			int take = -prices[idx] + recursion(idx + 1, 0, prices, Dp);
			int nottake = recursion(idx + 1, 1, prices, Dp);
			return Dp[idx][buy] = Math.max(nottake, take);
		} else {
			int selling = prices[idx] + recursion(idx + 2, 1, prices, Dp); // cooldown
			int notselling = recursion(idx + 1, 0, prices, Dp);
			return Dp[idx][buy] = Math.max(notselling, selling);
		}
	}
}
