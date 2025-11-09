package Linked_List_2;

import java.util.*;

public class remove_Duplicates_Sorted {
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
			System.out.println("Enter The Data(Sorted) ");
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
		System.out.println("The LinkedList : -");
		Print(head);
		head = Remove_Duplicates(head);
		System.out.println("The Tree Afer Removing Duplicates");
		Print(head);
	}

	private static ListNode Remove_Duplicates(ListNode head) {
		if(head == null || head.next == null) return null;
		ListNode temp = head;
		while(temp != null && temp.next != null) {
			if(temp.data == temp.next.data) {
				temp.next = temp.next.next;
				temp = temp.next;
			}else {
				temp = temp.next;
			}
		}
		return head;
	}

}
