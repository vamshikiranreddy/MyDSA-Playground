package Paranthesis;

import java.util.*;

public class Longest_Valid_paranthesis {
	private static int Longest_paranthesis(String s) {
		int n = s.length();
		int max_length = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					max_length = Math.max(max_length, i - stack.peek());
				}
			}
		}
		return max_length;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Paranthesis in ( ");
		String s = in.nextLine();
		int result = Longest_paranthesis(s);
		System.out.println("The Longest paranthesis is " + result);
		in.close();

	}

}
