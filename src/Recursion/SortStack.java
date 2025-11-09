package Recursion;

import java.util.*;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(2);

		System.out.println("Original Stack: " + stack);

		sortStack(stack);

		System.out.println("Sorted Stack: " + stack);

	}

	private static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) return;
		int top = stack.pop();
		sortStack(stack);
		insertStack(stack,top);
	}

	private static void insertStack(Stack<Integer> stack, int topval) {
		if(stack.isEmpty() || topval > stack.peek()) {
			stack.push(topval);
			return;
		}
		int toptempval = stack.pop();
		insertStack(stack,topval);
		stack.push(toptempval);
	}

}
