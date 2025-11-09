package Linked_List_3;

import java.util.*;

public class Double_The_data {
	static class ListNode {
		int data;
		ListNode next;
		ListNode prev;

		ListNode() {
		}

		ListNode(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	static Scanner in = new Scanner(System.in);

	private static ListNode Create() {
		ListNode head = null;
		ListNode temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Ndoe Created !!");
			System.out.println("Enter The Data : ");
			int data = in.nextInt();
			ListNode newNode = new ListNode(data);
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				newNode.prev = temp;
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("More Nodes ? 1.Yes 2.No");
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

	private static void Print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.println("Null------");
	}

	public static void main(String[] args) {
		ListNode head = Create();
		System.out.println("The List : -");
		Print(head);
		System.out.println();
		head = Double(head);
		System.out.println("The List After Doubling Function :-");
		Print(head);
	}

	private static ListNode Double(ListNode head) {
		ListNode temp = head;
		if (head.data > 4) {
			ListNode newNode = new ListNode(1);
			newNode.next = head;
			head = newNode;
		}
		while (temp != null) {
			int carry = 0;
			if (temp.next != null && temp.next.data > 4) {
				carry = 1;
			}
			int value = (temp.data * 2 + carry) % 10;
			temp.data = value;
			temp = temp.next;
		}
		return head;
	}

}
