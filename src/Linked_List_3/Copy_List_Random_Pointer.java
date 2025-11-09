package Linked_List_3;

import java.util.*;

public class Copy_List_Random_Pointer {
	static class Node {
		int data;
		Node next;
		Node random;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}

	static Scanner in = new Scanner(System.in);

	public static Node Create() {
		Node head = null;
		Node temp = null;
		ArrayList<Node> nodes = new ArrayList<>();
		boolean Continue = true;

		while (Continue) {
			System.out.println("New Node Created ");
			System.out.print("Enter The data: ");
			int data = in.nextInt();
			Node newNode = new Node(data);
			nodes.add(newNode);

			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				temp = newNode;
			}

			System.out.println("Need More? 1.Yes 2.No");
			int choice = in.nextInt();
			Continue = (choice == 1);
		}

		// Assign random pointers
		for (int i = 0; i < nodes.size(); i++) {
			System.out.print(
					"Enter random pointer index for node " + i + " (data=" + nodes.get(i).data + ") (-1 for null): ");
			int randIndex = in.nextInt();
			if (randIndex >= 0 && randIndex < nodes.size()) {
				nodes.get(i).random = nodes.get(randIndex);
			}
		}

		return head;
	}

	public static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			String randVal = (temp.random != null) ? String.valueOf(temp.random.data) : "null";
			System.out.print(temp.data + "(random->" + randVal + ") -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		Node head = Create();
		System.out.println("The Linked List:");
		print(head);

		Node Clone_head = Clone(head);
		System.out.println("The Cloned List:");
		print(Clone_head);
	}

	public static Node Clone(Node head) {
		if (head == null)
			return null;

		Map<Node, Node> map = new HashMap<>();
		Node current = head;

		// Step 1: Create new nodes and put in map
		while (current != null) {
			map.put(current, new Node(current.data));
			current = current.next;
		}

		// Step 2: Assign next and random using the map
		current = head;
		while (current != null) {
			Node clone = map.get(current);
			clone.next = map.get(current.next);
			clone.random = map.get(current.random);
			current = current.next;
		}

		return map.get(head);
	}
}
