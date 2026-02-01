package Stack_And_Queue_2;

import java.util.*;

public class Infix_To_PostFix {

	public static void main(String[] args) {
		String Infixexp = "(p+q)*(m-n)";
		String Postfixexp = infixToPostfix(Infixexp);
		System.out.println("Infix expression: " + Infixexp + "to PostFix: " + Postfixexp);

	}

	public static int ComparePriority(char op) {
		if (op == '^')
			return 3;
		else if (op == '*' || op == '/')
			return 2;
		else if (op == '+' || op == '-')
			return 1;
		else
			return -1;
	}

	private static String infixToPostfix(String infixexp) {
		int n = infixexp.length();
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char ch = infixexp.charAt(i);
			if (Character.isLetter(ch)) {
				sb.append(ch);
			} else if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					sb.append(st.pop());
				}
				// removing (
				st.pop();
			} else {
				while (!st.isEmpty() && ComparePriority(ch) <= ComparePriority(st.peek())) {
					sb.append(st.pop());
				}
				st.push(ch);
			}
		}
		while (!st.isEmpty())
			sb.append(st.pop());
		return sb.toString();
	}

}
