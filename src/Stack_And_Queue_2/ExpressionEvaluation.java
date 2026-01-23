package Stack_And_Queue_2;

import java.util.*;

public class ExpressionEvaluation {

	static int valueOf(char ch, int A, int B, int C) {
		if (ch == 'A')
			return A;
		if (ch == 'B')
			return B;
		if (ch == 'C')
			return C;
		return 0;
	}

	// INFIX
	static int evaluateInfix(int A, int B, int C) {
		return (A + B) * C;
	}

	//  POSTFIX
	static int evaluatePostfix(String postfix, int A, int B, int C) {
		Stack<Integer> stack = new Stack<>();

		for (char ch : postfix.toCharArray()) {
			if (Character.isLetter(ch)) {
				stack.push(valueOf(ch, A, B, C));
			} else {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(applyOperator(a, b, ch));
			}
		}
		return stack.pop();
	}

	//  PREFIX
	static int evaluatePrefix(String prefix, int A, int B, int C) {
		Stack<Integer> stack = new Stack<>();

		for (int i = prefix.length() - 1; i >= 0; i--) {
			char ch = prefix.charAt(i);

			if (Character.isLetter(ch)) {
				stack.push(valueOf(ch, A, B, C));
			} else {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(applyOperator(a, b, ch));
			}
		}
		return stack.pop();
	}

	//  OPERATORS LOGIC
	static int applyOperator(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b; // assume b != 0
		case '%':
			return a % b;
		case '^':
			return (int) Math.pow(a, b);
		}
		return 0;
	}

	// MAIN
	public static void main(String[] args) {
		int A = 2, B = 3, C = 4;

		String postfix = "AB+C*"; // (A + B) * C
		String prefix = "*+ABC"; // * + A B C

		System.out.println("Infix Result   : " + evaluateInfix(A, B, C));
		System.out.println("Postfix Result : " + evaluatePostfix(postfix, A, B, C));
		System.out.println("Prefix Result  : " + evaluatePrefix(prefix, A, B, C));
	}
}
