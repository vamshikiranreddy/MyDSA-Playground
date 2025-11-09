package Linked_List_2;

import java.util.*;

public class Swap_Nodes {
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
			while(Continue) {
				System.out.println("Node Created !!!!!!!");
				System.out.println("Enter The Data -- ");
				int data = in.nextInt();
				ListNode newNode = new ListNode(data);
				if(head == null) {
					head = newNode;
					temp = newNode;
				}else {
					temp.next = newNode;
					newNode.prev = temp;
					temp = newNode;
				}
				System.out.println("Need more ???? \n 1.Hell Yea 2.Hell Nahh");
				int choice = in.nextInt();
				if(choice == 1) {
					Continue = true;
				}else if(choice == 2) {
					Continue = false;
				}else {
					System.out.println("Invalid Choice !!!!!!");
				}
			}
			return head;
		}
	
	public static void Print(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
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
		head = Swap(head);
		System.out.println("The List After Swaping ");
		Print(head);
	}
	
	public static ListNode Swap(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pointer = dummyNode;
		while(pointer.next != null && pointer.next.next != null) {
			ListNode swaper1 = pointer.next;
			ListNode swaper2 = pointer.next.next;
			//swapping
			swaper1.next = swaper2.next;
			swaper2.next = swaper1;
			//moving
			pointer.next = swaper2;
			pointer = swaper1;
		}
		return dummyNode.next;
	}
}
