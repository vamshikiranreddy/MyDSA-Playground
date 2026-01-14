package Stack_And_Queue;

import java.util.Stack;

public class Maxstack {
	static class MaxStack {
	    private Stack<Integer> mainStack;
	    private Stack<Integer> maxStack;

	    public MaxStack() {
	        mainStack = new Stack<>();
	        maxStack = new Stack<>();
	    }

	    public void push(int x) {
	        mainStack.push(x);
	        if (maxStack.isEmpty() || x >= maxStack.peek()) {
	            maxStack.push(x);
	        }
	    }

	    public void pop() {
	        if (mainStack.isEmpty()) {
	            System.out.println("Stack is empty, cannot pop.");
	            return;
	        }
	        int popped = mainStack.pop();
	        if (popped == maxStack.peek()) {
	            maxStack.pop();
	        }
	    }

	    public int top() {
	        if (mainStack.isEmpty()) {
	            throw new RuntimeException("Stack is empty");
	        }
	        return mainStack.peek();
	    }

	    public int getMax() {
	        if (maxStack.isEmpty()) {
	            throw new RuntimeException("Stack is empty");
	        }
	        return maxStack.peek();
	    }

	    public boolean isEmpty() {
	        return mainStack.isEmpty();
	    }
	}
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();

        stack.push(5);
        stack.push(1);
        stack.push(10);
        stack.push(3);

        System.out.println("Top: " + stack.top());       // 3
        System.out.println("Max: " + stack.getMax());    // 10

        stack.pop(); // Pops 3
        System.out.println("Top: " + stack.top());       // 10
        System.out.println("Max: " + stack.getMax());    // 10

        stack.pop(); // Pops 10
        System.out.println("Top: " + stack.top());       // 1
        System.out.println("Max: " + stack.getMax());    // 5

        stack.pop(); // Pops 1
        stack.pop(); // Pops 5

        System.out.println("Is Empty? " + stack.isEmpty()); // true
    }
}
