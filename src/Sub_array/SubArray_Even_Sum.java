package Sub_array;

import java.util.*;

public class SubArray_Even_Sum {
	public static int numOfSubarrays(int[] arr) {
		int MOD = 1000000007; // Modulo to handle large numbers
		int prefixSum = 0; // Tracks the cumulative sum
		int oddCount = 0; // Counts prefix sums that are odd
		int evenCount = 1; // Counts prefix sums that are even (prefixSum of 0 is even)
		int result = 0; // Stores the final count of subarrays with odd sums

		for (int num : arr) {
			prefixSum += num; // Update the prefix sum
			if (prefixSum % 2 == 1) {
				// If prefixSum is odd, add evenCount to result
				result = (result + evenCount) % MOD;
				oddCount++; // Increment oddCount
			} else {
				// If prefixSum is even, add oddCount to result
				result = (result + oddCount) % MOD;
				evenCount++; // Increment evenCount
			}
		}

		return result;
	}

	/*
	 * // Brute-force method (O(n^2) time complexity) public static int
	 * numOfSubarraysBruteForce(int[] arr) { int n = arr.length; int count = 0; for
	 * (int i = 0; i < n; i++) { int sum = 0; for (int j = i; j < n; j++) { sum +=
	 * arr[j]; if (sum % 2 != 0) { count++; } } } return count; }
	 */

	public static void main(String[] args) {
		// Create a Scanner object to take input
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter the size of the array
		System.out.print("Enter the size of the array: ");
		int n = scanner.nextInt();

		// Create an array of the given size
		int[] arr = new int[n];

		// Prompt the user to enter the array elements
		System.out.print("Enter the array elements: ");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		// Call the optimized method
		int result = numOfSubarrays(arr);

		// Call the brute-force method (commented out)
		// int resultBruteForce = numOfSubarraysBruteForce(arr);

		// Print the result
		System.out.println("Number of subarrays with odd sum (optimized): " + result);

		// Print the brute-force result (commented out)
		// System.out.println("Number of subarrays with odd sum (brute-force): " +
		// resultBruteForce);

		// Close the scanner
		scanner.close();
	}
}
