package Stack_And_Queue_2;

import java.util.*;

public class Prefix_To_Postfix {
	public static void main(String[] args) {
		String prefix = "*-A/BC-/AKL";
		System.out.println("Postfix Expression: " + prefixToPostfix(prefix));
	}

	private static String prefixToPostfix(String prefix) {
		int n = prefix.length();
		Stack<String> st = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			char ch = prefix.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				st.push(String.valueOf(ch));
			} else {
				String op2 = st.pop();
				String op1 = st.pop();
				String operation = op1 + op2 + ch;
				st.push(operation);
			}
		}
		return st.peek();
	}

}
