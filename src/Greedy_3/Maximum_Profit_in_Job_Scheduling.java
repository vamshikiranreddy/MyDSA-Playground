package Greedy_3;

import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {

	public static void main(String[] args) {
		int[] deadline = { 2, 1, 2, 1, 1 };
		int[] profit = { 100, 19, 27, 25, 15 };

		List<Integer> ans = jobSequencing(deadline, profit);
		System.out.println(ans.get(0) + " " + ans.get(1));

	}

	static class Job {
		int id;
		int deadline;
		int profit;

		Job(int id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	private static List<Integer> jobSequencing(int[] deadline, int[] profit) {
		Job[] array = new Job[profit.length];
		for (int i = 0; i < profit.length; i++) {
			array[i] = new Job(i + 1, deadline[i], profit[i]);
		}
		Arrays.sort(array, (a, b) -> b.profit - a.profit);
		int maxDeadline = -1;
		for (int i = 0; i < array.length; i++) {
			maxDeadline = Math.max(maxDeadline, array[i].deadline);
		}
		int[] result = new int[array.length];
		Arrays.fill(result, -1);
		int countJobs = 0;
		int maxProfit = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = array[i].deadline; j > 0; j--) {
				if (result[j] == -1) {
					result[j] = i;
					countJobs++;
					maxProfit += array[i].profit;
					break;
				}
			}
		}
		List<Integer> res = new ArrayList<>();
		res.add(countJobs);
		res.add(maxProfit);
		return res;
	}

}
