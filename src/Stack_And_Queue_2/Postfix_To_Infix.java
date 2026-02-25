package Stack_And_Queue_2;

import java.util.*;

public class Postfix_To_Infix {

	public static void main(String[] args) {
		String postfix = "AB*C+";
		System.out.println("Infix Expression: " + postfixToInfix(postfix));

	}

	private static String postfixToInfix(String postfix) {
		int n = postfix.length();
		Stack<String>  stack = new Stack<>();
		for(int i = 0;i < n;i++) {
			char ch = postfix.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				stack.push(String.valueOf(ch));
			}else {
				String b = stack.pop();
				String a = stack.pop();
				String resultant = "(" + a + ch + b + ")";
				stack.push(resultant);
			}
		}
		return stack.peek();
	}

}
