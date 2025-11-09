package BackTracking_2;

import java.util.*;

public class CombinationalSum3 {

    public static void main(String[] args) {
        int k = 3; // number of elements in combination
        int n = 7; // target sum

        List<List<Integer>> result = combinationSum3(k, n);

        System.out.println("Combinations of " + k + " numbers summing to " + n + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int k, int target, List<Integer> currList, List<List<Integer>> result) {
        // Base case: exact k numbers and target reached
        if (currList.size() == k && target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        // Prune paths that exceed k numbers or target < 0
        if (currList.size() > k || target < 0) return;

        for (int i = start; i <= 9; i++) {
            currList.add(i);
            backtrack(i + 1, k, target - i, currList, result); // move to next number
            currList.remove(currList.size() - 1); // backtrack
        }
    }
}
