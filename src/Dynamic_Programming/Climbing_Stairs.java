package Dynamic_Programming;

import java.util.Arrays;

public class Climbing_Stairs {
    static int[] dp;

    public static void main(String[] args) {
        int n = 5; // Example input: number of steps
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = climbStairs(n);
        System.out.println("Number of ways to climb " + n + " stairs: " + result);
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
}
