package BackTracking_2;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};      // no duplicates
        int[] nums2 = {1, 1, 2};      // with duplicates

        System.out.println("Permutations (no duplicates): " + permute(nums1));
        System.out.println("Unique Permutations (with duplicates): " + permuteUnique(nums2));
    }

    // ------------------ No duplicates ------------------
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, current, used, result);

            current.remove(current.size() - 1); // backtrack
            used[i] = false;
        }
    }

    // ------------------ With duplicates ------------------
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrackUnique(nums, new ArrayList<>(), used, result);
        return result;
    }

    private static void backtrackUnique(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // skip duplicates at the same recursion level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            current.add(nums[i]);
            used[i] = true;

            backtrackUnique(nums, current, used, result);

            current.remove(current.size() - 1); // backtrack
            used[i] = false;
        }
    }
}
