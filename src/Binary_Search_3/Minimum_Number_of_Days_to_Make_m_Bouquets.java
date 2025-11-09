package Binary_Search_3;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;

        // Not enough flowers to make m bouquets
        if (n < val) return -1;

        // Find minimum and maximum days
        int minDays = Integer.MAX_VALUE;
        int maxDays = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minDays = Math.min(minDays, bloomDay[i]);
            maxDays = Math.max(maxDays, bloomDay[i]);
        }

        // Binary search between minDays and maxDays
        int low = minDays, high = maxDays;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (PossibleBloom(bloomDay, m, k, mid)) {
                high = mid - 1; // try smaller days
            } else {
                low = mid + 1;  // need more days
            }
        }
        return low;
    }

    private static boolean PossibleBloom(int[] bloomDay, int m, int k, int day) {
        int count = 0;     // consecutive bloomed flowers
        int bouquets = 0;  // number of bouquets formed

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                bouquets += count / k; // use the streak
                count = 0;
            }
        }
        bouquets += count / k; // last streak

        return bouquets >= m;
    }

    // Test run
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(minDays(bloomDay, m, k)); // Expected: 3
    }
}
