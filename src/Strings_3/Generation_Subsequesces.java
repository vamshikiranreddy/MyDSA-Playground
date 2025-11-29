package Strings_3;

import java.util.*;

public class Generation_Subsequesces {

	public static void main(String[] args) {
		String s = "abc";
		List<String> res = new ArrayList<>();
		generate(0, s, new StringBuilder(), res);
		System.out.println(res);
	}

	public static void generate(int idx, String s, StringBuilder sb, List<String> res) {
		// Base Case
		if (idx == s.length()) {
			res.add(sb.toString());
			return;
		}

		// INCLUDE current character
		sb.append(s.charAt(idx));
		generate(idx + 1, s, sb, res);

		// BACKTRACK (remove last character)
		sb.deleteCharAt(sb.length() - 1);

		// EXCLUDE current character
		generate(idx + 1, s, sb, res);
	}
}
