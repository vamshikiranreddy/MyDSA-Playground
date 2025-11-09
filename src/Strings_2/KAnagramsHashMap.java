package Strings_2;

import java.util.*;

public class KAnagramsHashMap {
    public static boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency of characters in s2
        for (char c : s2.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int changes = 0;

        // Traverse s1 and try to match with s2
        for (char c : s1.toCharArray()) {
            if (freq.containsKey(c) && freq.get(c) > 0) {
                // Match found, decrement count
                freq.put(c, freq.get(c) - 1);
            } else {
                // Must change this char
                changes++;
                if (changes > k) return false; // early stop
            }
        }

        return changes <= k;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "grammar";
        int k = 3;

        System.out.println(areKAnagrams(s1, s2, k)); // true
    }
}

