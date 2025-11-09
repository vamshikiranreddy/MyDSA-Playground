package Linked_List_2;

import java.util.*;

public class Even_Odd_Numbers {
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
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
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
		System.out.println("The Tree");
		Print(head);
		head = EvenOdd_List(head);
		System.out.println("The Tree Afer Even Odd Segregation ");
		Print(head);
	}

	public static ListNode EvenOdd_List(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode even = new ListNode(-1);
		ListNode odd = new ListNode(-1);
		ListNode evenHead = even;
		ListNode oddHead = odd;
		ListNode temp = head;
		while (temp != null) {
			if (temp.data % 2 == 0) {
				even.next = temp;
				even = even.next;
			}else {
				odd.next = temp;
				odd = odd.next;
			}
			temp = temp.next;
		}
		odd.next = null;
		even.next = oddHead.next;
		return evenHead.next;
	}
}
