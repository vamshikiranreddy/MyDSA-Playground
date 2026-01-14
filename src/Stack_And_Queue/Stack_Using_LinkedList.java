package Stack_And_Queue;

public class Stack_Using_LinkedList {

	static class LinkedListStack {

		static class ListNode {
			int data;
			ListNode next;

			ListNode(int data) {
				this.data = data;
				this.next = null;
			}
		}

		ListNode head; // Top of Stack
		int size;

		LinkedListStack() {
			head = null;
			size = 0;
		}

		private boolean isEmpty() {
			return size == 0;
		}

		private int top() {
			if (head == null)
				return -1;
			return head.data;
		}

		private int pop() {
			if (head == null)
				return -1;
			int val = head.data;
			ListNode temp = head;
			head = head.next;
			temp = null;
			size--;
			return val;
		}

		private void push(int data) {
			ListNode newNode = new ListNode(data);
			newNode.next = head;
			head = newNode;
			size++;
		}
	}

	public static void main(String[] args) {
		// Creating a stack
		LinkedListStack st = new LinkedListStack();

		// Array of commands
		String[] commands = { "LinkedListStack", "push", "push", "pop", "top", "isEmpty" };
		// Array of inputs
		int[][] inputs = { {}, { 3 }, { 7 }, {}, {}, {} };

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].equals("push")) {
				st.push(inputs[i][0]);
				System.out.print("null ");
			} else if (commands[i].equals("pop")) {
				System.out.print(st.pop() + " ");
			} else if (commands[i].equals("top")) {
				System.out.print(st.top() + " ");
			} else if (commands[i].equals("isEmpty")) {
				System.out.print((st.isEmpty() ? "true" : "false") + " ");
			} else if (commands[i].equals("LinkedListStack")) {
				System.out.print("null ");
			}
		}
	}
}
