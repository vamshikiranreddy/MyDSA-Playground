package Sliding_Window;

public class LongestSubArray_Condition {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 1, 7, 10 };
		int k = 14;
		int Brutelength = LongestSubArrBrute(arr, k);
		System.out.println("The Length Of The LongestSubArray With sum (Brute) <= " + k + " is:" + Brutelength);

		int Betterlength = LongestSubArrBetter(arr, k);
		System.out.println("The Length Of The LongestSubArray With sum (Better) <= " + k + " is:" + Betterlength);
		
		int Optimallength = LongestSubArrOptimal(arr, k);
		System.out.println("The Length Of The LongestSubArray With sum (Optimal) <= " + k + " is:" + Optimallength);
	}

	private static int LongestSubArrOptimal(int[] arr, int k) {
		int n = arr.length;
		int maxLen = 0;
		int sum = 0;
		int left = 0, right = 0;
		while (right < n) {
			sum += arr[right];
			if (sum > k) {
				sum -= arr[left++];
			}
			if (sum <= k) {
				maxLen = Math.max(maxLen, right - left + 1);// (sum += arr[right++]) if no + 1 here because the right pointer has moved
			}
			right++;
		}
		return maxLen;
	}

	private static int LongestSubArrBetter(int[] arr, int k) {
		int n = arr.length;
		int maxLen = 0;
		int sum = 0;
		int left = 0, right = 0;
		while (right < n) {
			sum += arr[right];
			while (sum > k) {
				sum -= arr[left++];
			}
			if (sum <= k) {
				maxLen = Math.max(maxLen, right - left + 1);// (sum += arr[right++]) if no + 1 here because the right pointer has moved
			}
			right++;
		}
		return maxLen;
	}

	private static int LongestSubArrBrute(int[] arr, int k) {
		int n = arr.length;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum <= k) {
					maxLen = Math.max(maxLen, j - i + 1);
				} else if (sum > k) {
					break;
				}
			}
		}
		return maxLen;
	}

}
