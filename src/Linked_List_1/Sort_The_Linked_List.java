package Linked_List_1;

import java.util.*;

class NODE_1 {
	int data;
	NODE_1 next;
	NODE_1(int data){
		this.data = data;
		this.next = null;
	}
}

public class Sort_The_Linked_List {

	public static Scanner in = new Scanner(System.in);

	public static NODE_1 Create_Linked_List() {
		NODE_1 head = null;
		NODE_1 temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("NODE Created !!!!!!!!");
			System.out.println("Enter The Node : ");
			int data = in.nextInt();
			NODE_1 newNode = new NODE_1(data);
			
			if (head == null) {
				temp = newNode;
				head = newNode;
			} else {
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("NEED MORE ?? 1.YES 2.NO");
			int choice = in.nextInt();
			in.nextLine();
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
		}
		return head;
	}

	private static void Print(NODE_1 head) {
		NODE_1 temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.println("NULL");

	}

	public static NODE_1 Sort(NODE_1 head) {
		if(head == null || head.next == null ) return head;
		NODE_1 temp = head;
		NODE_1 fast = head;
		NODE_1 slow = head;
		while (fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		temp.next = null;
		NODE_1 left_list = Sort(head);
		NODE_1 right_list = Sort(slow);
		return merge(left_list, right_list);
	}

	private static NODE_1 merge(NODE_1 l1, NODE_1 l2) {
		NODE_1 sorted_temp = new NODE_1(0);
		NODE_1  current_node = sorted_temp;
		while (l1 != null && l2 != null) {
			if(l1.data<l2.data) {
				current_node.next = l1;
				l1 = l1.next;
			}else {
				current_node.next = l2;
				l2 = l2.next;
			}
			current_node = current_node.next;
		}
		while(l1 != null) {
			current_node.next = l1;
			l1 = l1.next;
			current_node = current_node.next;
		}
		while(l2 != null) {
			current_node.next = l2;
			l2 = l2.next;
			current_node = current_node.next;
		}
		return sorted_temp.next;
	}

	public static void main(String[] args) {
		NODE_1 head = Create_Linked_List();
		System.out.println("The Original Linked List : ");
		Print(head);
		head = Sort(head);
		System.out.println("The Sorted Linked List : ");
		Print(head);
	}

}
