package Recursion_2;

import java.util.*;

public class CombinationalSum_2 {

	public static void main(String[] args) {
		int[] candidates = { 1, 2, 2, 1, 1};
		int target = 4;

		List<List<Integer>> result = combinationSum(candidates, target);

		System.out.println("Combinations that sum to " + target + ":");
		for (List<Integer> comb : result) {
			System.out.println(comb);
		}

	}

	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		recursion(0, nums, target, new ArrayList<Integer>(), result);
		return result;
	}

	private static void recursion(int idx, int[] nums, int target, ArrayList<Integer> currList,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(currList));
			return;
		}
		for (int i = idx; i < nums.length; i++) {
			if (i > idx && nums[i] == nums[i - 1])
				continue; // use an index once at each level
			if (nums[i] > target)
				break;
			currList.add(nums[i]);
			recursion(i + 1, nums, target - nums[i], currList, result);
			currList.remove(currList.size() - 1);
		}
	}

}
