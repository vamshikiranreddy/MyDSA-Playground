package Strings_3;

import java.util.*;

public class PermutationsString {

    public static void main(String[] args) {
        String str = "abc"; // test input
        List<String> result = permute(str);
        System.out.println("Permutations of \"" + str + "\": " + result);
    }

    public static List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        backtrack(str, new StringBuilder(), used, result);
        return result;
    }

    private static void backtrack(String str, StringBuilder current, boolean[] used, List<String> result) {
        if (current.length() == str.length()) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i]) continue; // skip used characters

            current.append(str.charAt(i));
            used[i] = true;

            backtrack(str, current, used, result);

            current.deleteCharAt(current.length() - 1); // backtrack
            used[i] = false;
        }
    }
}
