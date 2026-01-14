package Stack_And_Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        int size = q.size();
        // Rotate queue to make last added element come to the front
        for (int i = 1; i < size; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.poll();
    }

    public int top() {
        if (q.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class implement_stack_queue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); // 30
        System.out.println("Popped: " + stack.pop());      // 30
        System.out.println("Top element: " + stack.top()); // 20
        System.out.println("Is stack empty? " + stack.empty()); // false

        stack.pop(); // Pops 20
        stack.pop(); // Pops 10

        System.out.println("Is stack empty? " + stack.empty()); // true
    }
}
