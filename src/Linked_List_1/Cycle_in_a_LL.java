package Linked_List_1;

import java.util.*;

class Node_2 {
	int data;
	Node_2 next;
}

public class Cycle_in_a_LL {
	public static Scanner in = new Scanner(System.in);

	private static Node_2 Create() {
		Node_2 head = null;
		Node_2 temp = null;
		boolean Continue = true;
		while (Continue) {
			Node_2 newNode = new Node_2();
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

	private static boolean hasCycle(Node_2 head) {
		if(head == null || head.next == null) return false;
		Node_2 slow = head;
		Node_2 fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Node_2 head = Create();
		if (hasCycle(head)) {
			System.out.println("The Linked List has a cycle!!!");
		} else {
			System.out.println("The Linked List dosenot have a cycle!!!");
		}
	}

}
