package Strings_2;

import java.util.*;

public class SortVowels {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "lEetcOde";
        System.out.println(sol.sortVowels(s)); // Output: lEOtcEde
    }
}

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Collect vowels
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        // Sort vowels
        Collections.sort(vowels);

        // Build result
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                result.append(vowels.get(i++));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
