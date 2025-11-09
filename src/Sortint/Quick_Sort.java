package Sortint;

import java.util.*;

public class Quick_Sort {
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
		Quick_sort(nums, 0, nums.length - 1);
		System.out.println("After Sorting :");
		Print(nums);
		in.close();
	}

	public static void Quick_sort(int[] nums, int low, int high) {
		if (low < high) {
			int pivot_index = Partition(nums, low, high);
			Quick_sort(nums, low, pivot_index - 1);
			Quick_sort(nums, pivot_index + 1, high);
		}
	}

	private static int Partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (nums[j] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		i++;
		int temp = nums[i];
		nums[i] = nums[high];
		nums[high] = temp;
		return i;
	}
}
