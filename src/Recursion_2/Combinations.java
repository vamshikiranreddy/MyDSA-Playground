package Recursion_2;

import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        int n = 4; // numbers from 1 to n
        int k = 2; // size of each combination

        List<List<Integer>> result = combine(n, k);
        System.out.println("Combinations of " + n + " taken " + k + " at a time: " + result);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k, List<Integer> currList, List<List<Integer>> result) {
        if (currList.size() == k) {
            result.add(new ArrayList<>(currList)); // add a copy
            return;
        }

        // loop from current start to n
        for (int num = start; num <= n; num++) {
            currList.add(num);                   // choose
            backtrack(num + 1, n, k, currList, result); // explore
            currList.remove(currList.size() - 1);       // backtrack
        }
    }
}
