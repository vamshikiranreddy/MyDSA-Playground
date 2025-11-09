package Sortint;

import java.util.*;

public class Bubble_Sort {

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
		Bubble_sort(nums);
		System.out.println("After Sorting :");
		Print(nums);
		in.close();
	}

	public static void Bubble_sort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (nums[j + 1] < nums[j]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}

	}

}
