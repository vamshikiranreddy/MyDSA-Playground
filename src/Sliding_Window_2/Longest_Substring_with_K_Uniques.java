package Sliding_Window_2;

import java.util.*;

public class Longest_Substring_with_K_Uniques {
	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;

		System.out.println("length Of Longest Substring KDistinct is : "+lengthOfLongestSubstringKDistinct(s, k));
	}

	private static int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> freqMap = new HashMap<>();
		char[] arr = s.toCharArray();
		int n = arr.length;
		int left = 0, right = 0, max = -1;
		while (right < n) {
			freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
			if (freqMap.size() > k) {
				while (freqMap.size() > k) {
					freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
					if (freqMap.get(arr[left]) == 0) {
						freqMap.remove(arr[left]);
					}
					left++;
				}
			}
			if (freqMap.size() == k) {
				max = Math.max(max, right - left + 1);
			}
			right++;
		}
		return max;
	}
}
