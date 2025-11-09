package Linked_List_4;

import java.util.*;

public class Swap_Nodes {
	static class ListNode {
		int data;
		ListNode next;

		ListNode() {
		}

		ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static Scanner in = new Scanner(System.in);

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
		System.out.println("Enter The Kth Value :-");
		int k = in.nextInt();

		head = Swap_LL_K(head, k);

		System.out.println("Reversed Linked List");
		Print(head);
	}

	private static ListNode Swap_LL_K(ListNode head, int k) {
		ListNode first = head;
		for (int i = 1; i < k; i++) {
			first = first.next;
		}
		ListNode tempNode = first;
		ListNode second = head;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
			second = second.next;
		}
		int tempVal = first.data;
		first.data = second.data;
		second.data = tempVal;
		return head;
	}

}
