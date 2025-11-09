package Sortint;

import java.util.Scanner;

public class Merge_Sort {

	public static void Print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array : ");
		int size = in.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter The Elements : -");
		for (int i = 0; i < size; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println("The Elements");
		Print(nums);
		int[] result = Merge_sort(nums);
		System.out.println("After Sorting :");
		Print(result);
		in.close();
	}

	private static int[] Merge_sort(int[] nums) {
		int n = nums.length;
		if (n <= 1) {
			return nums;
		}
		int middle = n / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[n - middle];
		for (int i = 0; i < middle; i++) {
			leftArray[i] = nums[i];
		}
		for (int i = middle, j = 0; i < n; i++, j++) {
			rightArray[j] = nums[i];
		}
		leftArray = Merge_sort(leftArray);
		rightArray = Merge_sort(rightArray);
		return Sort(leftArray, rightArray);
	}

	private static int[] Sort(int[] leftArray, int[] rightArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int[] merged = new int[leftSize + rightSize];
		int l = 0, r = 0, i = 0;
		while (l < leftSize && r < rightSize) {
			if (leftArray[l] < rightArray[r]) {
				merged[i++] = leftArray[l++];
			} else {
				merged[i++] = rightArray[r++];
			}
		}
		while (l < leftSize) {
			merged[i++] = leftArray[l++];
		}
		while (r < rightSize) {
			merged[i++] = rightArray[r++];
		}
		return merged;
	}
}
