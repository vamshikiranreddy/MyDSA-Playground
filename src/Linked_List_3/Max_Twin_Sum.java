package Linked_List_3;

import java.util.*;

public class Max_Twin_Sum {

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
			System.out.println("Node Created \n Enter The Data");
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
			System.out.println("Need more ? \n  1.Yes 2.No");
			int choice = in.nextInt();
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
		}
		return head;
	}

	public static void Print(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.print("Null-----");
	}

	public static void main(String[] args) {
		ListNode head = Create();
		System.out.println("The List ");
		Print(head);
		System.out.println();
		int max = Max_Twin_Sum(head);
		System.out.println("The Maximum twin Sum is " + max);

	}

	private static int Max_Twin_Sum(ListNode head) {
		if (head == null) {
			return -1;
		}
		List<Integer> list = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		int max = Integer.MIN_VALUE;
		int n = list.size();
		for (int i = 0; i < n / 2; i++) {
			int x = list.get(i) + list.get(n - i - 1);
			max = Math.max(max, x);
		}
		return max;
	}

}
