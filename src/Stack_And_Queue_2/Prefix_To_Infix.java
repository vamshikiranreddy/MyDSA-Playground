package Stack_And_Queue_2;

import java.util.*;

public class Prefix_To_Infix {

	public static void main(String[] args) {
		String Prefixexp = "*+pq-mn";
		String Infixexp = prefixToInfix(Prefixexp);

		System.out.println("Prefix expression: " + Prefixexp);
		System.out.println("Infix expression: " + Infixexp);
	}

	private static String prefixToInfix(String prefix) {
		int n = prefix.length();
		Stack<String>  stack = new Stack<>();
		for(int i = n - 1;i >= 0;i--) {
			char ch = prefix.charAt(i);
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
