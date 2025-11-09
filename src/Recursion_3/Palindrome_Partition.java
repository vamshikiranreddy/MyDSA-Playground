package Recursion_3;

import java.util.*;

public class Palindrome_Partition {

	public static void main(String[] args) {
		String s = "aabb"; // test input
		List<List<String>> result = partition(s);

		// Print result
		for (List<String> path : result) {
			System.out.println(path);
		}
	}

	private static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		recursion(0, s, path, result);
		return result;
	}

	private static void recursion(int idx, String s, List<String> path, List<List<String>> result) {
		if (idx == s.length()) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = idx; i < s.length(); i++) {
			if (isPalindrome(idx, i, s)) {
				path.add(s.substring(idx,i + 1));
				recursion(i + 1,s,path,result);
				path.remove(path.size()-1);
			}
		}
	}

	private static boolean isPalindrome(int left, int right, String s) {
		while(left < right) {
			if(s.charAt(left++) != s.charAt(right--)) return false;
		}
		return true;
	}

}
