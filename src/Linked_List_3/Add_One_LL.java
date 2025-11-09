package Linked_List_3;

import java.util.Scanner;

public class Add_One_LL {
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
			System.out.println("Node Created !!!!!!!");
			System.out.println("Enter The Data -- ");
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
			System.out.println("Need more ???? \n 1.Hell Yea 2.Hell Nahh");
			int choice = in.nextInt();
			if (choice == 1) {
				Continue = true;
			} else if (choice == 2) {
				Continue = false;
			} else {
				System.out.println("Invalid Choice !!!!!!");
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
		System.out.print("Null");
		System.out.println();
	}

	public static void main(String [] args) {
		ListNode head = Create();
		System.out.println("The List ");
		Print(head);
		head = AddOne(head);
		System.out.println("The List After Adding ");
		Print(head);
	}
	public static ListNode Reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	private static ListNode AddOne(ListNode head) {
		head = Reverse(head);
		int carry = 1;
		ListNode temp = head;
		ListNode prev = null;
		while(temp != null) {
			int sum = temp.data + carry;
			temp.data = sum % 10;
			carry = sum / 10;
			prev = temp;
			temp = temp.next;
		}
		if(carry > 0) prev.next = new ListNode(carry);
		head = Reverse(head);
		return head;
	}
}
