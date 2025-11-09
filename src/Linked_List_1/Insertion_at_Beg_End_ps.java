package Linked_List_1;

import java.util.*;

class Node_5 {
	int data;
	Node_5 next;

	Node_5(int data) {
		this.data = data;
		this.next = null;
	}

}

public class Insertion_at_Beg_End_ps {
	public static Scanner in = new Scanner(System.in);

	public static Node_5 Create() {
		Node_5 head = null;
		Node_5 temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node Created!!!!");
			System.out.println("Enter The data :");
			int data = in.nextInt();
			Node_5 newNode = new Node_5(data);
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
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
		}
		return head;
	}

	public static void print(Node_5 head) {
		Node_5 temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	public static void main(String[] args) {
		Node_5 head = Create();
		System.out.println("Choose The Operation : ");
		System.out.println("1.Insertion At Begening");
		System.out.println("2.Insertion At Position");
		System.out.println("Insertions At End ");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter The Value for insertion ");
			int value = in.nextInt();
			head = At_Begening(head, value);
			System.out.println("After Insertion : ");
			print(head);
			break;
		case 2:
			System.out.println("Enter The position for insertion ");
			int pos = in.nextInt();
			System.out.println("Enter The Value for insertion ");
			int value1 = in.nextInt();
			head = At_Pos(head, value1, pos);
			System.out.println("After Insertion : ");
			print(head);
			break;
		case 3:
			System.out.println("Enter The Value for insertion ");
			int value2 = in.nextInt();
			head = At_End(head, value2);
			System.out.println("After Insertion : ");
			print(head);
			break;
		default:
			System.out.println("Invalid Operation !!!!!!!!!!");
		}
	}

	private static Node_5 At_Pos(Node_5 head, int value1, int pos) {
		Node_5 newNode = new Node_5(value1);
		if (pos <= 0) {
			System.out.println("Invlaid Position");
		}
		if (pos == 1) {
			At_Begening(head, value1);
		}
		Node_5 temp = head;
		for (int i = 1; temp != null && i < pos - 1; i++) {
			temp = temp.next; // to reach position -1
		}
		newNode.next = temp.next;
		temp.next = newNode;

		return head;
	}

	private static Node_5 At_End(Node_5 head, int value2) {
		Node_5 newNode = new Node_5(value2);
		if (head == null) {
			head = newNode;
		}
		Node_5 current_Node = head;
		while (current_Node.next != null) {
			current_Node = current_Node.next;
		}
		current_Node.next = newNode;
		return head;
	}

	private static Node_5 At_Begening(Node_5 head, int value) {
		Node_5 newNode = new Node_5(value);
		if (head == null) {
			head = newNode;
		}
		newNode.next = head;
		return newNode;
	}

}
