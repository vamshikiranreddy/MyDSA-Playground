package Dynamic_Programming_4;

import java.util.Arrays;

public class CoinChange_Two {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;

        System.out.println("Memoization Result : " + coinChangeMemo(coins, amount));
        System.out.println("Tabulization Result : " + coinChangeTab(coins, amount));
        System.out.println("Space Optimized Result : " + coinChangeOpt(coins, amount));
    }

    private static int coinChangeTab(int[] coins, int target) {
        int n = coins.length;
        int[][] Dp = new int[n][target + 1];

        // Base case
        for (int t = 0; t <= target; t++) {
            if (t % coins[0] == 0)
                Dp[0][t] = 1;
            else
                Dp[0][t] = 0;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int t = 0; t <= target; t++) {
                int nottake = Dp[idx - 1][t];

                int take = 0;
                if (coins[idx] <= t) {
                    take = Dp[idx][t - coins[idx]];  // stay on same row for counting
                }

                Dp[idx][t] = nottake + take;
            }
        }

        return Dp[n - 1][target];
    }

    private static int coinChangeMemo(int[] coins, int amount) {
        int n = coins.length;
        int[][] Dp = new int[n][amount + 1];
        for (int[] row : Dp)
            Arrays.fill(row, -1);

        return recursion(n - 1, amount, coins, Dp);
    }

    private static int recursion(int idx, int target, int[] coins, int[][] Dp) {
        // Base case
        if (idx == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }

        if (Dp[idx][target] != -1)
            return Dp[idx][target];

        int nottake = recursion(idx - 1, target, coins, Dp);

        int take = 0;
        if (coins[idx] <= target) {
            take = recursion(idx, target - coins[idx], coins, Dp);
        }

        return Dp[idx][target] = nottake + take;
    }

    private static int coinChangeOpt(int[] coins, int target) {
        int n = coins.length;

        int[] prev = new int[target + 1];

        // Base case
        for (int t = 0; t <= target; t++) {
            if (t % coins[0] == 0)
                prev[t] = 1;
            else
                prev[t] = 0;
        }

        for (int idx = 1; idx < n; idx++) {
            int[] curr = new int[target + 1];
            for (int t = 0; t <= target; t++) {
                int nottake = prev[t];

                int take = 0;
                if (coins[idx] <= t) {
                    take = curr[t - coins[idx]];  // use curr because unbounded
                }

                curr[t] = take + nottake;
            }
            prev = curr;
        }

        return prev[target];
    }
}
