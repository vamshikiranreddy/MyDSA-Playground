package PriorityQueue;

import java.util.*;

public class maxScore {
	private static int getMaxScore(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int[][] pairs = new int[n][2];
		for (int i = 0; i < n; i++) {
			pairs[i] = new int[] { nums1[i], nums2[i] };
		}
		
		Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
		int sum = 0;
		int max_Score = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int num1 = pairs[i][0];
			int num2 = pairs[i][1];
			minHeap.offer(num1);
			sum += num1;
			if (minHeap.size() > k) {
				sum -= minHeap.poll();
			}
			if (minHeap.size() == k) {
				max_Score = Math.max(max_Score, sum * num2);
			}
		}
		return max_Score;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size ");
		int size = in.nextInt();
		int[] nums1 = new int[size];
		System.out.println("Enter The Size of 1st Array:");
		for (int i = 0; i < size; i++) {
			nums1[i] = in.nextInt();
		}
		System.out.println("Enter The Size of 2nd Array:");
		int[] nums2 = new int[size];
		for (int i = 0; i < size; i++) {
			nums2[i] = in.nextInt();
		}
		System.out.println("Give The Size of The window k");
		int k = in.nextInt();
		int Max_Score = getMaxScore(nums1, nums2, k);
		System.out.println("The Max Score is " + Max_Score);
		in.close();
	}

}
