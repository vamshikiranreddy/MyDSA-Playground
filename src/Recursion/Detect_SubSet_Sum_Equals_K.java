package Recursion;

public class Detect_SubSet_Sum_Equals_K {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		int K = 3;
		if (isPresent(arr, K)) {
			System.out.println("There exists a subsequence with sum " + K);
		} else {
			System.out.println("There Does not exists a subsequence with sum " + K);
		}

	}

	private static boolean isPresent(int[] arr, int k) {
		return recursion(0, 0, arr, k);
	}

	private static boolean recursion(int idx, int sum, int[] arr, int k) {
		if (idx == arr.length) {
			return sum == k;
		}
		// Include
		if (recursion(idx + 1, sum + arr[idx], arr, k))
			return true;
		if (recursion(idx + 1, sum, arr, k))
			return true;
		return false;
	}

}
