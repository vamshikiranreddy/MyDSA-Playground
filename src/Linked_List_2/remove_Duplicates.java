package Linked_List_2;

import java.util.*;

public class remove_Duplicates {
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
		head = Remove_Duplicates(head);
		System.out.println("The Tree Afer Removing Duplicates");
		Print(head);
	}

	private static ListNode Remove_Duplicates(ListNode head) {
		if(head == null) {
			return null;
		}
		Set<Integer> set = new HashSet<>();
		ListNode temp = head;
		ListNode prev = null;
		while(temp !=null) {
			if(set.contains(temp.data)) {
				prev.next = temp.next;
			}else {
				set.add(temp.data);
				prev = temp;
			}
			temp = temp.next;
		}
		
		return head;
	}
}