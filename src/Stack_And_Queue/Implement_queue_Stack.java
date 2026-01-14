package Stack_And_Queue;

import java.util.Stack;

class MyQueue {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        shiftStacks();
        if (outputStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return outputStack.pop();
    }

    public int peek() {
        shiftStacks();
        if (outputStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

public class Implement_queue_Stack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front: " + queue.peek()); // 10
        System.out.println("Popped: " + queue.pop()); // 10
        System.out.println("Front: " + queue.peek()); // 20
        System.out.println("Is empty? " + queue.empty()); // false

        queue.pop(); // 20
        queue.pop(); // 30
        System.out.println("Is empty? " + queue.empty()); // true
    }
}
