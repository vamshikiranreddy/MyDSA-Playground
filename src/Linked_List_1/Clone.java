package Linked_List_1;
import java.util.*;
public class Clone {
	static Scanner in = new Scanner(System.in);
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static Node Create() {
		Node head = null;
		Node temp = null;
		boolean Continue = true;
		while(Continue) {
			System.out.println("New Node Created ");
			System.out.println("Enter The data: ");
			int data = in.nextInt();
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				temp = newNode;
			}else {
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("Need More? 1.Yes 2.No");
			int choice = in.nextInt();
			if(choice == 1) {
				Continue = true;
			}else {
				Continue = false;
			}
		}
		return head;
	}
	public static void print(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("Null");
	}
	public static void main(String[]args) {
		Node head = Create();
		System.out.println("The Linked List ");
		print(head);
		System.out.println();
		Node Clone_head = Clone(head);
		System.out.println("The Clone is");
		print(Clone_head);
		System.out.println();
	}
	public static Node Clone(Node head) {
		if(head == null) {
			return null;
		}
		Node clone_head = new Node(head.data);
		Node current = head.next;
		Node current_clone = clone_head;
		while(current != null) {
			Node newNode = new Node(current.data);
			current_clone.next = newNode;
			current_clone = newNode;
			current = current.next;
		}
		return clone_head;
		
	}
	
}
