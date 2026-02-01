package Stack_And_Queue_2;

import java.util.*;

public class Infix_To_Prefix {

	public static void main(String[] args) {
		String infixExp = "(p+q)*(m-n)";
		String prefixExp = infixToPrefix(infixExp);

		System.out.println("Infix expression  : " + infixExp);
		System.out.println("Prefix expression : " + prefixExp);

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

	private static String infixToPrefix(String InfixExp) {
		String ReverseInfixExp = reverse(InfixExp);
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = ReverseInfixExp.length();
		for (int i = 0; i < n; i++) {
			char ch = ReverseInfixExp.charAt(i);
			if (Character.isLetter(ch)) {
				sb.append(ch);
			} else if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					sb.append(st.pop());
				}
				st.pop(); // remove '('
			} else {
				while (!st.isEmpty() && ComparePriority(ch) < ComparePriority(st.peek())) {
					sb.append(st.pop());
				}
				st.push(ch);
			}
		}
		while (!st.isEmpty())
			sb.append(st.pop());
		return sb.reverse().toString();
	}

	private static String reverse(String InfixExp) {
		StringBuilder sb = new StringBuilder();
		int n = InfixExp.length();
		for (int i = n - 1; i >= 0; i--) {
			char ch = InfixExp.charAt(i);
			if (ch == '(')
				sb.append(')');
			else if (ch == ')')
				sb.append('(');
			else
				sb.append(ch);
		}
		return sb.toString();
	}

}
