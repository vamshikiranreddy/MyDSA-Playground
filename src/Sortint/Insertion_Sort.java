package Sortint;

import java.util.*;;

public class Insertion_Sort {
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
		Insertion_sort(nums);
		System.out.println("After Sorting :");
		Print(nums);
		in.close();
	}

	public static void Insertion_sort(int[] nums) {
		for(int i = 1;i<nums.length;i++) {
			int value = nums[i];
			int j = i-1;
			while(j >= 0 && nums[j] > value) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j+1] = value;
		}
		
	}

}
