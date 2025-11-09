package Dynamic_Programming_2;

import java.util.*;

public class Ninja_Trainng {

	public static void main(String[] args) {
		int[][] arr = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };

		System.out.println("Maximum Points = " + maximumPoints(arr));
	}

	static int[][] Dp;

	public static int maximumPoints(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		Dp = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			Arrays.fill(Dp[i], -1);
		}
		return Solver(m - 1, n, arr);
	}

	private static int Solver(int day, int last, int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		if (day == 0) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (i != last) {
					max = Math.max(max, arr[day][i]);
				}
			}
			return max;
		}
		if (Dp[day][last] != -1)
			return Dp[day][last];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int points = 0;
			if (i != last) {
				points = arr[day][i] + Solver(day - 1, i, arr);
			}
			max = Math.max(max, points);
		}
		return Dp[day][last] = max;
	}
}
