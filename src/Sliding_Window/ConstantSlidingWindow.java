package Sliding_Window;

public class ConstantSlidingWindow {

	public static void main(String[] args) {
		int [] arr = {-1,2,3,4,5,-1};
		int k = 4;
		
		int constantWindowAns = ConstantWindow(arr,k);
		System.out.println("The maxSum for ConstantWindow Sliding of Length " + k + " is: " + constantWindowAns);

	}

	private static int ConstantWindow(int[] arr, int k) {
		int n = arr.length;
		int sum = 0;
		for(int i = 0;i < k;i++) {
			sum += arr[i];
		}
		int maxSum = 0;
		int left = 0,right = k - 1;
		while(right < n - 1) {
			sum = sum - arr[left];
			left++;
			right++;
			sum = sum + arr[right];
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
