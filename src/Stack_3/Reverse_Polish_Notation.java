package Stack_3;

import java.util.*;

public class Reverse_Polish_Notation {

	public static void main(String[] args) {
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println("Result 1 = " + evalRPN(tokens1)); // 9
		String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println("Result 2 = " + evalRPN(tokens2)); // 6
		String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println("Result 3 = " + evalRPN(tokens3)); // 22

	}

	private static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		String operations = "+-*/";
		for(String token : tokens) {
			if(operations.indexOf(token) != -1) {
				int b = stack.pop();
				int a = stack.pop();
				switch (token) {
				case("+") : stack.push(a + b); break;
				case("-") : stack.push(a - b); break;
				case("*") : stack.push(a * b); break;
				case("/") : stack.push(a / b); break;
				}
			}else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
	}

}
