package Greedy_3;

import java.util.*;

public class insertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };

		int[][] result = insert(intervals, newInterval);

		System.out.print("Result: ");
		for (int[] interval : result) {
			System.out.print(Arrays.toString(interval) + " ");
		}

	}

	private static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int i = 0;
		int n = intervals.length;

		// Add all intervals before newInterval
		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		// Merge overlapping intervals
		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			i++;
		}
		result.add(newInterval);

		// Add remaining intervals
		while (i < n) {
			result.add(intervals[i]);
			i++;
		}

		return result.toArray(new int[result.size()][]);
	}

}
