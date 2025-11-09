package Greedy_2;

import java.util.*;

public class Merge_OverLaping_Intervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge by updating the end
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    // Utility method to print intervals
    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
    
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };
        
        int[][] mergedIntervals = merge(intervals);
        System.out.println("Merged Intervals:");
        printIntervals(mergedIntervals);
    }
}
