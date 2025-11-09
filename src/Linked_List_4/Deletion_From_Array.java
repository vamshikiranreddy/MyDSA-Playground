package Linked_List_4;

import java.util.*;

public class Deletion_From_Array {
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

	public static ListNode Create() {
		ListNode temp = null;
		ListNode head = null;
		boolean Continue = true;
		int count = 1;
		while (Continue) {
			System.out.println("Enter The Data for newnode no "+ count++ + ":-");
			int data = in.nextInt();
			ListNode newNode = new ListNode(data);
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				newNode.prev = temp;
				temp = temp.next;
			}
			System.out.println("Need More ? 1.Yes 2.No");
			int choice = in.nextInt();
			if (choice == 1)
				Continue = true;
			else
				Continue = false;
		}
		return head;
	}

	public static void Print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	public static void main(String[] args) {

		System.out.println("Enter The Size Of The Array :");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Array Elements :-");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		ListNode head = Create();
		System.out.println("The Array :- ");
		System.out.println(Arrays.toString(arr));
		System.out.println("The LinkedList :- ");
		Print(head);
		System.out.println("The LinkedList After Deletion :- ");
		head = Deletion(head, arr);
		Print(head);
		in.close();
	}

	private static ListNode Deletion(ListNode head, int[] nums) {
		Set<Integer> NumSet = new HashSet<>();
		for (int num : nums)
			NumSet.add(num);
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead, curr = head;
		while (curr != null) {
			if (NumSet.contains(curr.data)) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return dummyHead.next;
	}

}
