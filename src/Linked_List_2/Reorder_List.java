package Linked_List_2;

import java.util.*;

public class Reorder_List {
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

	static Scanner in = new Scanner(System.in);

	public static ListNode Create() {
		ListNode head = null;
		ListNode temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node Created !!!!!!!!!!!!!!");
			System.out.println("Enter The Data");
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
			System.out.println("Do You Need More ? 1. Yes 2. No");
			int choice = in.nextInt();
			Continue = (choice == 1);
		}
		return head;
	}

	public static void Print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.print("Null----");
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = Create();
		System.out.println("The List");
		Print(head);
		reorderList(head); 
		System.out.println("The List After Reordering");
		Print(head);
	}

	
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode current = slow.next;
		slow.next = null;
		ListNode prev = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		ListNode p1 = head;
		ListNode p2 = prev;
		while (p1 != null && p2 != null) {
			ListNode temp1 = p1.next;
			ListNode temp2 = p2.next;
			p1.next = p2;
			if (temp1 == null)
				break;
			p2.next = temp1;
			p1 = temp1;
			p2 = temp2;
		}
	}
}
