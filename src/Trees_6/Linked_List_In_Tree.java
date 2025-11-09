package Trees_6;

import java.util.*;

public class Linked_List_In_Tree {
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

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static ListNode Create_LinkedList() {
		ListNode temp = null;
		ListNode head = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("Node Create \n Enter The Data :-");
			int data = in.nextInt();
			ListNode newNode = new ListNode(data);
			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				newNode.prev = temp;
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("Want More ? 1. Yes 2.No");
			int choice = in.nextInt();
			if (choice == 1) {
				Continue = true;
			} else if (choice == 2) {
				Continue = false;
			} else {
				System.out.println("Invalid Option !");
			}
		}
		return head;
	}

	public static void Print_LinkedList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.next;
		}
		System.out.println("Null---");
	}

	static int idx;

	public static TreeNode Create_Tree(int[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create_Tree(arr);
		newNode.right = Create_Tree(arr);
		return newNode;
	}

	public static void Print_Tree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		Print_Tree(root.left);
		Print_Tree(root.right);
	}

	public static void main(String[] args) {
		ListNode head = Create_LinkedList();
		System.out.println("The LinkedList :- ");
		Print_LinkedList(head);
		System.out.println("Enter The Size Of The Array:- ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 for No Child) :- ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create_Tree(arr);
		System.out.println("The Tree(Pre-Order):-");
		Print_Tree(root);
		System.out.println();
		if (isSubList(head, root)) {
			System.out.println("Yes The Linked List is Present in The Tree");
		} else {
			System.out.println("No The Linked List is Not Present in The Tree");
		}
	}

	public static boolean isSubList(ListNode head, TreeNode root) {
		if (root == null)
			return false;
		return DFS(root, head) || isSubList(head, root.left) || isSubList(head, root.right);
	}

	public static boolean DFS(TreeNode root, ListNode head) {
		// if the linked List has reached End it means the linked list is present
		if (head == null)
			return true;
		// if the TreeNode has reached null then the linked list is not present in the
		// path or this side of the Tree
		if (root == null)
			return false;
		if (root.data != head.data)
			return false;
		return DFS(root.left, head.next) || DFS(root.right, head.next);
	}

}
