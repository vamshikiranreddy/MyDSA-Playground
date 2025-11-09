package Strings_2;

import java.util.*;

public class minimumDelitionsUnqFrq {

    public static int minDeletions(String s) {
        // Step 1: Count character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Keep track of used frequencies
        Set<Integer> usedFreq = new HashSet<>();
        int deletions = 0;

        // Step 3: Make all frequencies unique
        for (int freq : freqMap.values()) {
            while (freq > 0 && usedFreq.contains(freq)) {
                freq--; // delete one occurrence
                deletions++;
            }
            usedFreq.add(freq);
        }

        return deletions;
    }

    public static void main(String[] args) {
        String s = "aaabbbcc"; // example input
        int result = minDeletions(s);
        System.out.println("Minimum deletions to make frequencies unique: " + result);
    }
}

