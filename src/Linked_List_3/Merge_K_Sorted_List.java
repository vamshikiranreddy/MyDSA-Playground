package Linked_List_3;

import java.util.*;


public class Merge_K_Sorted_List {

	static Scanner in = new Scanner(System.in);

	static class ListNode {
		int data;
		ListNode next;
		ListNode prev;

		ListNode(int data) {
			this.data = data;
			this.next = this.prev = null;
		}
	}

	public static ListNode create() {
		ListNode head = null;
		ListNode temp = null;
		boolean Continue = true;
		while(Continue) {
			System.out.println("Node Created \n Enter The Data");
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
			System.out.println("Need More 1.yes 2.No : ");
			int choice = in.nextInt();
			if(choice == 1) Continue = true;
			else Continue = false;
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
		System.out.println("Enter The Number Of Linked List needed : ");
		int k = in.nextInt();
		ListNode[] lists = new ListNode[k];
		int j = 1;
		for (int i = 0; i < k; i++) {
			System.out.println("Creating the " + j + " linkedlist");
			ListNode temp_list = create();
			lists[i] = temp_list;
			j++;
		}
		j = 1;
		System.out.println("The LinkedLists : ");
		for (int i = 0; i < k; i++) {
			System.out.println(j + " LinkedList");
			Print(lists[i]);
			j++;
		}
		ListNode sorted_list = merge(lists);
		System.out.println("The Sorted List : ");
		Print(sorted_list);
	}
	private static ListNode merge(ListNode[] lists) {
		if(lists.length == 0 || lists[0] == null) return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
		for(ListNode list_head : lists) {
			pq.offer(list_head);
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(!pq.isEmpty()) {
			ListNode smallest = pq.poll();
			tail.next = smallest;
			tail = smallest;
			if(smallest.next != null) pq.offer(smallest.next);
		}
		return dummy.next;
	}

	

}
