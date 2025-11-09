package Binary_Search;

import java.util.*;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 8, 5, 6, 7, 8 }; // example array with duplicate
		int duplicate = findDuplicate(nums);
		int dup = BainarySearch(nums);
		System.out.println("Duplicate number (Set) : " + duplicate);
		System.out.println("Duplicate number (BinarySearch): " + dup);
	}

	private static int BainarySearch(int[] nums) {
		int low = 0;
		int high = nums.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int cnt = 0;
			for (int num : nums) {
				if (num <= mid)
					cnt++;
			}
			if (cnt > mid)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public static int findDuplicate(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		for (int num : nums) {
			if (!seen.add(num)) {
				return num; // found duplicate
			}
		}
		return -1; // no duplicate
	}
}
