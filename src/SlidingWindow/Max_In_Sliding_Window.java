package SlidingWindow;

import java.util.*;

public class Max_In_Sliding_Window {
	private static int[] SlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int Result[] = new int[n - k + 1];
		Deque<Integer> result = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (!result.isEmpty() && result.peekFirst() == i - k) {
				result.removeFirst();
			}
			while (!result.isEmpty() && nums[result.peekLast()] < nums[i]) {
				result.removeLast();
			}
			result.offer(i);
			if (i + 1 >= k) {
				Result[i + 1 - k] = nums[result.peekFirst()];
			}
		}
		return Result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array");
		int size = in.nextInt();
		System.out.println("Enter The Array Elements : ");
		int nums[] = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println("Enter The window size : ");
		int k = in.nextInt();
		int result[] = SlidingWindow(nums, k);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		in.close();
	}

}
