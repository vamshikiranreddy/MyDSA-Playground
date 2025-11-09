package Linked_List_1;

import java.util.*;

class Node_7 {
	int data;
	Node_7 next;

	Node_7(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Deleting_nth_node_from_Back {
	public static Scanner in = new Scanner(System.in);

	private static Node_7 Delete(Node_7 head, int n) {
		if (head == null) {
			return null;
		}
		int size = 0;
		Node_7 Current = head;
		while (Current != null) {
			Current = Current.next;
			size++;
		}
		if (n == size)
			return head.next;

		int Index = size - n;
		Node_7 Current_Pos = head;
		for (int i = 1; i < Index; i++) {
			Current_Pos = Current_Pos.next;
		}
		Current_Pos.next = Current_Pos.next.next;
		return head;
	}

	private static void print(Node_7 head) {
		Node_7 temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	private static Node_7 Create() {
		Node_7 head = null;
		Node_7 temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node_Created !!!!!!!!");
			System.out.println("Enter The Data");
			int data = in.nextInt();
			Node_7 newNode = new Node_7(data);
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

	public static void main(String[] args) {
		Node_7 head = Create();
		System.out.println("The Original LinkedList : ");
		print(head);
		System.out.println("The Node to Be Deleted from last");
		int n = in.nextInt();
		head = Delete(head, n);
		System.out.println("The Segregated LinkedList : ");
		print(head);
	}

}
