package Stack_And_Queue_2;

import java.util.*;

public class Postfix_To_Prefix {
	public static void main(String[] args) {
		String postfix = "ABC/-AK/L-*";
		System.out.println("Prefix Expression: " + postfixToPrefix(postfix));
	}

	private static String postfixToPrefix(String postfix) {
		int n = postfix.length();
		Stack<String> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			char ch = postfix.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				st.push(String.valueOf(ch));
			} else {
				String op2 = st.pop();
				String op1 = st.pop();
				String operation = ch + op1 + op2;
				st.push(operation);
			}
		}
		return st.peek();
	}
}
