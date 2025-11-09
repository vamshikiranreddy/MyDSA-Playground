package Strings;
import java.util.*;
public class Vowels_HashSet {
  public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        // Define vowel set
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move left pointer to next vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right pointer to previous vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println("Original: " + input);
        System.out.println("Reversed Vowels: " + reverseVowels(input));

        input = "leetcode";
        System.out.println("Original: " + input);
        System.out.println("Reversed Vowels: " + reverseVowels(input));
    }
}
