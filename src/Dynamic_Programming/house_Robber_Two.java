package Dynamic_Programming;

import java.util.*;

public class house_Robber_Two {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2}; // sample input
        System.out.println("Maximum money robbed: " + rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        Integer[] dp1 = new Integer[n]; // case excluding last
        Integer[] dp2 = new Integer[n]; // case excluding first

        // Case 1: Rob from 0 → n-2
        int case1 = solve(nums, 0, n - 2, dp1);

        // Case 2: Rob from 1 → n-1
        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    private static int solve(int[] nums, int idx, int end, Integer[] dp) {
        if (idx > end)
            return 0;
        if (dp[idx] != null)
            return dp[idx];

        int pick = nums[idx] + solve(nums, idx + 2, end, dp);
        int skip = solve(nums, idx + 1, end, dp);

        return dp[idx] = Math.max(pick, skip);
    }
}
