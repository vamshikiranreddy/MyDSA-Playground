package Linked_List_4;

import java.util.*;

public class Reverse_LL_k_Groups {
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
		System.out.println("Enter The Kth Value :-");
		int k = in.nextInt();

		head = reverse_LL_K(head, k);

		System.out.println("Reversed Linked List");
		Print(head);
	}

	private static ListNode reverse_LL_K(ListNode head, int k) {
		ListNode tempNode = head;
		ListNode prevNode = null;
		ListNode nextNode = null;
		while (tempNode != null) {
			ListNode kthNode = getKthNode(tempNode, k);
			if (kthNode == null) {
				if (prevNode != null) {
					prevNode.next = tempNode;
					break;
				}
			}
			nextNode = kthNode.next;
			kthNode.next = null;
			ReverseList(tempNode);
			if (tempNode == head) {
				head = kthNode;
			} else {
				prevNode.next = kthNode;// connecting the previous reverse LinkedList
			}
			prevNode = tempNode;
			tempNode = nextNode;
		}
		return head;
	}

	private static ListNode ReverseList(ListNode head) {
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static ListNode getKthNode(ListNode head, int k) {
		ListNode temp = head;
		while (temp != null && k > 1) { // why k > 1 because if k > 0 if gives an extra node
			temp = temp.next;
			k--;
		}
		return temp;
	}

}
