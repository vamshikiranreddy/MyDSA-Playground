package Linked_List_1;

import java.util.*;

class Node {
	int data;
	Node next;
	Node prev;
}

public class Doubly_Linked_List {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Node head = null;
		Node temp = null;
		boolean Continue = true;
		while (Continue) {
			Node newNode = new Node();
			System.out.println("Node Created ");
			System.out.println("Enter The Data...........");
			newNode.data = in.nextInt();
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				newNode.prev = temp;
				temp = newNode;
			}
			System.out.println("DO You Want To Create Another Node ? 1-YES --- 2-No");
			int choice = in.nextInt();
			in.nextLine();
			if(choice == 1) Continue = true;
			else Continue = false;
		}
		System.out.println("The LinkedList is : ");
		temp = head;
		while(temp != null) {
			System.out.print(temp.data+" <-> ");
			temp = temp.next;
		}
		System.out.println("NULL");
		in.close();

	}

}
