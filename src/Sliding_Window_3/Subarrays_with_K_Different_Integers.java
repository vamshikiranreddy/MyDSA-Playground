package Sliding_Window_3;

public class Subarrays_with_K_Different_Integers {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3 };
		int k = 2;

		int bruteAns = subarraysWithKDistinctBrute(nums, k);
		int optAns = subarraysWithKDistinctOptimal(nums, k);

		System.out.println("Brute Force Answer: " + bruteAns);
		System.out.println("Optimal Answer: " + optAns);

	}

}
