package Stack_And_Queue;

public class Queue_Using_LinkedList {

    static class LinkedListQueue {

        static class ListNode {
            int data;
            ListNode next;

            ListNode(int data) {
                this.data = data;
                this.next = null;
            }
        }

        ListNode front, rear;
        int size;

        LinkedListQueue() {
            front = rear = null;
            size = 0;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Add element to queue (enqueue)
        public void enqueue(int data) {
            ListNode newNode = new ListNode(data);

            if (rear == null) { // empty queue
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        // Remove element from queue (dequeue)
        public int dequeue() {
            if (isEmpty())
                return -1;

            int val = front.data;
            front = front.next;

            if (front == null) // queue became empty
                rear = null;

            size--;
            return val;
        }

        // Get front element
        public int peek() {
            if (isEmpty())
                return -1;
            return front.data;
        }
    }

    public static void main(String[] args) {

        LinkedListQueue q = new LinkedListQueue();

        String[] commands = { "LinkedListQueue", "enqueue", "enqueue", "dequeue", "peek", "isEmpty" };
        int[][] inputs = { {}, { 3 }, { 7 }, {}, {}, {} };

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("enqueue")) {
                q.enqueue(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("dequeue")) {
                System.out.print(q.dequeue() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListQueue")) {
                System.out.print("null ");
            }
        }
    }
}
