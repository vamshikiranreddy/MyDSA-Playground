package Stack_And_Queue;

import java.util.*;

public class Minstack {

	static class MinStack {
		private Stack<Integer> mainStack;
		private Stack<Integer> minStack;

		public MinStack() {
			mainStack = new Stack<>();
			minStack = new Stack<>();
		}

		public void push(int x) {
			mainStack.push(x);
			// Push to minStack only if it's the first element or x <= current min
			if (minStack.isEmpty() || x <= minStack.peek()) {
				minStack.push(x);
			}
		}

		public void pop() {
			if (mainStack.isEmpty())
				return;

			int popped = mainStack.pop();
			if (!minStack.isEmpty() && popped == minStack.peek()) {
				minStack.pop();
			}
		}

		public int top() {
			if (mainStack.isEmpty())
				throw new RuntimeException("Stack is empty");
			return mainStack.peek();
		}

		public int getMin() {
			if (minStack.isEmpty())
				throw new RuntimeException("Stack is empty");
			return minStack.peek();
		}
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();

		stack.push(4);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(3);

		System.out.println("Min: " + stack.getMin()); // 1
		stack.pop(); // pop 3
		stack.pop(); // pop 1
		System.out.println("Min: " + stack.getMin()); // 2
		System.out.println("Top: " + stack.top()); // 5
	}
}
