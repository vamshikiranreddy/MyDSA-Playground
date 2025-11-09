package Linked_List_1;

import java.util.*;

class Node_6 {
	int data;
	Node_6 next;

	Node_6(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Deletion {
	public static Scanner in = new Scanner(System.in);

	public static Node_6 Create() {
		Node_6 head = null;
		Node_6 temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node Created!!!!");
			System.out.println("Enter The data :");
			int data = in.nextInt();
			Node_6 newNode = new Node_6(data);
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("Need More?? 1.Yes 2.No");
			int choice = in.nextInt();
			in.nextLine();
			Continue = choice == 1;
		}
		return head;
	}

	public static void print(Node_6 head) {
		Node_6 temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	public static void main(String[] args) {
		Node_6 head = Create();
		System.out.println("Choose The Operation: ");
		System.out.println("1. Deletion At Beginning");
		System.out.println("2. Deletion At Position");
		System.out.println("3. Deletion At End");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			head = Delete_At_Beginning(head);
			System.out.println("After Deletion:");
			print(head);
			break;
		case 2:
			System.out.println("Enter The position for deletion: ");
			int pos = in.nextInt();
			head = Delete_At_Pos(head, pos);
			System.out.println("After Deletion:");
			print(head);
			break;
		case 3:
			head = Delete_At_End(head);
			System.out.println("After Deletion:");
			print(head);
			break;
		default:
			System.out.println("Invalid Operation !!!!!!!!!!");
		}
	}

	private static Node_6 Delete_At_Beginning(Node_6 head) {
		if (head == null) {
			System.out.println("Invalid - List Is Empty");
			return null;
		}
		head = head.next;
		return head;
	}

	private static Node_6 Delete_At_Pos(Node_6 head, int pos) {
		if (head == null) {
			System.out.println("Invalid - List Is Empty");
			return null;
		}
		Node_6 Current = head;
		for (int i = 1; i < pos - 1 && Current != null; i++) {
			Current = Current.next;
		}
		if (Current == null || Current.next == null) {
			System.out.println("Invalid Position");
			return head;
		}
		Current.next = Current.next.next;
		return head;
	}

	private static Node_6 Delete_At_End(Node_6 head) {
		if (head == null) {
			System.out.println("Invalid - List Is Empty");
			return null;
		}
		if (head.next == null) {
			return null;
		}
		Node_6 second_last = head;
		Node_6 last = head.next;
		while (last.next != null) {
			last = last.next;
			second_last = second_last.next;
		}
		second_last.next = null;
		return head;
	}
}
