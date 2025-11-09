package Linked_List_2;

import java.util.*;

public class Partition_List_X {
	static Scanner in = new Scanner(System.in);

	static class ListNode {
		int data;
		ListNode next;
		ListNode prev;

		ListNode(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static ListNode Create() {
		ListNode head = null;
		ListNode temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node Created!!!");
			System.out.println("Enter The Data : ");
			int data = in.nextInt();
			ListNode newNode = new ListNode(data);
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				newNode.prev = temp;
				temp = newNode;
			}
			System.out.println("Need More ????? \n 1.Yes 2.No");
			int choice = in.nextInt();
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
		}
		return head;
	}

	public static void Print(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	public static void main(String[] args) {
		ListNode head = Create();
		System.out.println("The List");
		Print(head);
		System.out.println("Enter The Pivot Element : ");
		int x = in.nextInt();
		head = Partition(head, x);
		System.out.println("The List After Partition : ");
		Print(head);
	}

	public static ListNode Partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode lower = new ListNode(-1);
		ListNode higher = new ListNode(-1);
		ListNode curr_lower = lower;
		ListNode curr_higher = higher;
		ListNode temp = head;
		while (temp != null) {
			if (temp.data < x) {
				ListNode newNode = new ListNode(temp.data);
				curr_lower.next = newNode;
				curr_lower = curr_lower.next;
			} else {
				ListNode newNode  = new ListNode(temp.data);
				curr_higher.next = newNode;
				curr_higher = curr_higher.next;
			}
			temp = temp.next;
		}
		curr_lower.next = higher.next;
		return lower.next;
	}

}
