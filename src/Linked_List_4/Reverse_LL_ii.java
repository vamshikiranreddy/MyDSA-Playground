package Linked_List_4;

import java.util.Scanner;

public class Reverse_LL_ii {
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
		System.out.println("Enter The left (1-based) Value :-");
		int left = in.nextInt();
		System.out.println("Enter The right (1-based) Value :-");
		int right = in.nextInt();

		head = reverse_LL_K(head, left, right);

		System.out.println("Reversed Linked List");
		Print(head);
		in.close();
	}

	private static ListNode reverse_LL_K(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode leftPrev = dummy;
		ListNode curr = head;

		for (int i = 0; i < left - 1; i++) { // one based
			leftPrev = leftPrev.next;
			curr = curr.next;
		}

		ListNode subList_Head = curr;
		ListNode prev = null;
		ListNode next = null;
		// run left-right time which reverses all the nodes
		for (int i = 0; i <= right - left; i++) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		leftPrev.next = prev;
		subList_Head.next = curr;
		return head;
	}

}
