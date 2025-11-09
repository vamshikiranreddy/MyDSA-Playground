package Linked_List_1;

import java.util.*;

class List_Node {
	int data;
	List_Node next;
}

public class Rotate_Linked_List_K {
	public static Scanner in = new Scanner(System.in);

	private static List_Node create_linkedlist() {
		List_Node head = null;
		List_Node temp = null;
		boolean Continue = true;
		while (Continue) {
			List_Node newNode = new List_Node();
			System.out.println("Node Created !!!!!!!!!");
			System.out.println("Enter The Data : ");
			newNode.data = in.nextInt();
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = temp;
				temp = newNode;
			}
			System.out.println("Need New Node ? 1.Yes 2.Noo ");
			int choice = in.nextInt();
			in.nextLine();
			if (choice == 1)
				Continue = true;
			else
				Continue = false;
		}
		return head;
	}

	private static void print(List_Node head) {
		List_Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " >");
			temp = temp.next;
		}
		System.out.println("Null ");

	}

	private static List_Node rotate(List_Node head, int k) {
		if(head == null || head.next == null || k == 0) {
			return head;
		}
		int length = 1;
		List_Node current = head;
		while(current.next != null) {
			length++;
			current = current.next;
		}
		current.next = head;
		k %= length;
		int gap = length - k;
		List_Node temp = head;
		while(--gap>0) {
			temp = temp.next;
		}
		head = temp.next;
		temp.next = null;
		
		return head;
	}

	public static void main(String[] args) {
		List_Node head = create_linkedlist();
		System.out.println("The  Original Linked List : ");
		print(head);
		System.out.println("Enter The K value : ");
		int k = in.nextInt();
		System.out.println("The Rotated List : ");
		head = rotate(head, k);
		print(head);
	}
}
