package Recursion_2;

import java.util.*;

public class CombinationalSum {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> result = combinationSum(candidates, target);

		System.out.println("Combinations that sum to " + target + ":");
		for (List<Integer> comb : result) {
			System.out.println(comb);
		}

	}

	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		recursion(0, nums, target, new ArrayList<>(), result);
		return result;
	}

	private static void recursion(int idx, int[] nums, int target, ArrayList<Integer> currList,List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(currList));
			return;
		}
		if (idx == nums.length || target < 0)
			return;
		// Include The Same Idx
		currList.add(nums[idx]);
		recursion(idx, nums, target - nums[idx], currList, result);
		currList.remove(currList.size() - 1);
		// Include Other
		recursion(idx + 1, nums, target, currList, result);

	}

}
