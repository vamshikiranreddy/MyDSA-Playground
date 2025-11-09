package Intervels;

import java.util.*;

public class N_MettingRooms {

	public static void main(String[] args) {
		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };

		int result = maxMeetings(start, end);
		System.out.println("Maximum meetings: " + result);
	}

	private static int maxMeetings(int[] start, int[] end) {
		int n = start.length;
		int[][] meetings = new int[n][2];
		for (int i = 0; i < n; i++) {
			meetings[i][0] = start[i];
			meetings[i][1] = end[i];
		}
		Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
		int cnt = 1;
		int endtime = meetings[0][1];
		for (int i = 1; i < meetings.length; i++) {
			if (endtime < meetings[i][0]) {
				cnt++;
				endtime = meetings[i][1];
			}
		}
		return cnt;
	}
}
