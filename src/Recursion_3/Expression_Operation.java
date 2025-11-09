package Recursion_3;

import java.util.*;

public class Expression_Operation {
	public static void main(String[] args) {
		String num = "123";
		int target = 6;

		List<String> result = addOperators(num, target);

		for (String expr : result) {
			System.out.print(expr + " ");
		}
	}

	private static List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		recursion(0, num, target, "", result, 0, 0);
		return result;
	}

	private static void recursion(int idx, String num, int target, String resStr, List<String> result, long prev,
			long res) {
		if (idx == num.length()) {
			if (res == target) {
				result.add(resStr);
			}
			return;
		}
		String str = "";
		long currRes = 0;
		for (int i = idx; i < num.length(); i++) {
			if (i > idx && num.charAt(idx) == '0')
				break;
			str += num.charAt(i);
			currRes = currRes * 10 + (num.charAt(i) - '0');
			if (idx == 0) {
				recursion(i + 1, num, target, str, result, currRes, currRes);
			} else {
				recursion(i + 1, num, target, resStr + "+" + str, result, currRes, res + currRes);
				recursion(i + 1, num, target, resStr + "-" + str, result, -currRes, res - currRes);
				recursion(i + 1, num, target, resStr + "*" + str, result, prev * currRes,
						res - prev + (prev * currRes));

			}
		}
	}

}
