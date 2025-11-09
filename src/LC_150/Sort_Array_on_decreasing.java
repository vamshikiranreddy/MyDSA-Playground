package LC_150;

import java.util.*;

public class Sort_Array_on_decreasing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter the elements: ");
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Sort(nums);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i]);
		}
		sc.close();
	}

	private static void Sort(int[] nums) {
		if (nums.length < 0) {
			return;
		}
		Arrays.sort(nums);
		ReverseArray(nums);
	}

	private static void ReverseArray(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}

	}

}
