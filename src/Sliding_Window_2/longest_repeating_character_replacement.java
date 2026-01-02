package Sliding_Window_2;

public class longest_repeating_character_replacement {
	public static void main(String[] args) {
		String s = "ABAB";
		int k = 2;
		// Output: 4
		System.out.println(characterReplacement(s, k));
	}

	private static int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int n = s.length();
		int left = 0, right = 0;
		int maxCount = 0, maxLen = 0;
		while (right < n) {
			freq[s.charAt(right) - 'A']++;
			maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
			while ((right - left + 1) - maxCount > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}
			maxLen = Math.max(maxCount, right - left + 1);
			right++;
		}
		return maxLen;
	}
}
