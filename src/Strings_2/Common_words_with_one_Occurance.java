package Strings_2;

import java.util.*;

public class Common_words_with_one_Occurance {
    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> freq1 = new HashMap<>();
        HashMap<String, Integer> freq2 = new HashMap<>();

        // Count occurrences in words1
        for (String word : words1) {
            freq1.put(word, freq1.getOrDefault(word, 0) + 1);
        }

        // Count occurrences in words2
        for (String word : words2) {
            freq2.put(word, freq2.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        // Count words that appear exactly once in both maps
        for (String word : freq1.keySet()) {
            if (freq1.get(word) == 1 && freq2.getOrDefault(word, 0) == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for first list
        System.out.println("Enter the number of words in words1:");
        int n1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] words1 = new String[n1];
        System.out.println("Enter words for words1:");
        for (int i = 0; i < n1; i++) {
            words1[i] = scanner.next();
        }

        // Take input for second list
        System.out.println("Enter the number of words in words2:");
        int n2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] words2 = new String[n2];
        System.out.println("Enter words for words2:");
        for (int i = 0; i < n2; i++) {
            words2[i] = scanner.next();
        }

        scanner.close();

        // Directly call the static method without creating an object
        int result = countWords(words1, words2);
        System.out.println("Count of common words with one occurrence: " + result);
    }
}
