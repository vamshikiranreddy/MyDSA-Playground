package Linked_List_1;

import java.util.*;

class ListNode {
	int data;
	ListNode next;
}

public class Reverse_Linked_list {
	private static Scanner in = new Scanner(System.in);

	private static ListNode Create_Linked_List() {
		ListNode head = null;
		ListNode temp = null;
		boolean Continue = true;
		while (Continue) {
			ListNode newNode = new ListNode();
			System.out.println("Node Created !!!!!!!");
			System.out.println("Enter The Data : ");
			newNode.data = in.nextInt();
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("More Nodes ? 1.Yes 2.No");
			int choice = in.nextInt();
			in.nextLine();
			if (choice == 1)
				Continue = true;
			else
				Continue = false;
		}
		return head;
	}

	private static ListNode reverse_Linked_list(ListNode head) {
		ListNode next = null;
		ListNode current = head;
		ListNode prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static void Print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");

	}

	public static void main(String[] args) {
		ListNode head = Create_Linked_List();
		System.out.println("Original Linked List ");
		Print(head);

		head = reverse_Linked_list(head);

		System.out.println("Reversed Linked List");
		Print(head);
	}

}
