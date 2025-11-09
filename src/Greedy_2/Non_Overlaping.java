package Greedy_2;

import java.util.Arrays;

public class Non_Overlaping {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {
            {0, 5},
            {3, 4},
            {1, 2},
            {5, 9},
            {5, 7},
            {7, 9}
        };

        int removals = solution.eraseOverlapIntervals(intervals);
        System.out.println("Minimum intervals to remove: " + removals);
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
