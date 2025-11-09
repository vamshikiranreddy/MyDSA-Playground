package Linked_List_3;

import java.util.*;

public class Flaten_LinkedList_DFS {
	static class ListNode {
		int data;
		ListNode next;
		ListNode prev;
		ListNode child;

		ListNode(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
			this.child = null;
		}
	}

	static Scanner in = new Scanner(System.in);

	public static ListNode Create() {
		ListNode head = null;
		ListNode temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node Create !!!!");
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

			System.out.println("Need Child for this node ??? \n 1.yes 2.no");
			int childChoice = in.nextInt();
			if (childChoice == 1) {
				newNode.child = Create();
			}
			System.out.println("Do You Need More Nodes in This Level? 1. Yes 2. No");
			int choice = in.nextInt();
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
		}
		return head;
	}

	public static void PrintMultiLevel(ListNode head) {
	    printLevel(head, 0);
	}

	private static void printLevel(ListNode head, int level) {
	    ListNode temp = head;
	    while (temp != null) {
	        for (int i = 0; i < level; i++) System.out.print("    "); // indentation
	        System.out.println(temp.data);

	        if (temp.child != null) {
	            for (int i = 0; i < level; i++) System.out.print("    ");
	            System.out.println("|");
	            printLevel(temp.child, level + 1);
	        }

	        temp = temp.next;
	    }
	}


	public static void main(String[] args) {
		ListNode head = Create();
		System.out.println("The Multilevel List ");
		PrintMultiLevel(head);
		System.out.println();
		head = flatten(head);
		System.out.println("The Flatten Tree");
		PrintMultiLevel(head);
	}

	private static ListNode flatten(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode temp = head;
		while (temp != null) {
			if (temp.child != null) {
				ListNode next = temp.next;
				ListNode child = flatten(temp.child);
				temp.child = null;
				temp.next = child;
				child.prev = temp;
				while (child.next != null) {
					child = child.next;
				}
				child.next = next;
				if (next != null) {
					next.prev = child;
					temp = child;
				}
			}
			temp = temp.next;
		}
		return head;
	}

}
