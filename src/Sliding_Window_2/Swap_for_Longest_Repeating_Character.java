package Sliding_Window_2;

public class Swap_for_Longest_Repeating_Character {

    public static void main(String[] args) {

        String text1 = "ababa";
        String text2 = "aaabaaa";
        String text3 = "aaaaa";

        System.out.println(maxRepOpt1(text1)); // 3
        System.out.println(maxRepOpt1(text2)); // 6
        System.out.println(maxRepOpt1(text3)); // 5
    }

    public static int maxRepOpt1(String text) {
        int n = text.length();
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxLen = 0;

        // Try each character as repeated character
        for (int ch = 0; ch < 26; ch++) {
            int left = 0, mismatch = 0;

            for (int right = 0; right < n; right++) {
                if (text.charAt(right) - 'a' != ch) {
                    mismatch++;
                }

                while (mismatch > 1) {
                    if (text.charAt(left) - 'a' != ch) {
                        mismatch--;
                    }
                    left++;
                }

                int windowLen = right - left + 1;
                maxLen = Math.max(maxLen, Math.min(windowLen, freq[ch]));
            }
        }
        return maxLen;
    }
}
