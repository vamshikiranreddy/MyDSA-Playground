package Sliding_Window_3;

import java.util.*;

public class Minimum_Window_SubString {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";

		String ans = minWindow(s, t);
		System.out.println("Minimum Window Substring: " + ans);

	}

	private static String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();
		int left = 0, right = 0;
		int count = 0, MinLen = (int) 1e9, startIdx = -1;
		int[] Hash = new int[256];
		for (int i = 0; i < n; i++)
			Hash[t.charAt(i)]++;
		while (right < m) {
			if (Hash[s.charAt(right)] > 0) {
				count++;
			}
			Hash[s.charAt(right)]--;
			while (count == n) {
				if (right - left + 1 < MinLen) {
					MinLen = right - left + 1;
					startIdx = left;
				}
				Hash[s.charAt(left)]++;
				if (Hash[s.charAt(left)] > 0)
					count--;
				left++;
			}
			right++;
		}
		return startIdx == -1 ? "" : s.substring(startIdx, startIdx + MinLen);
	}

}
