package BST_1;

import java.util.*;

public class Kth_Largest {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static TreeNode Insert(TreeNode root, int num) {
		if (root == null) {
			root = new TreeNode(num);
			return root;
		}
		if (num < root.data) {
			root.left = Insert(root.left, num);
		} else {
			root.right = Insert(root.right, num);
		}
		return root;
	}

	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		TreeNode root = null;
		for (int i = 0; i < size; i++) {
			root = Insert(root, arr[i]);
		}
		System.out.println("The Tree (BST)");
		print(root);
		System.out.println();
		System.out.println("Enter  k ");
		int k = in.nextInt();
		int result = kthLargest(root, k);
		System.out.println("The Kth Largest Element is " + result);
	}

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	private static int kthLargest(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		Traverse(root, k);
		return minHeap.peek();
	}

	private static void Traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		Traverse(root.left, k);
		minHeap.offer(root.data);
		if (minHeap.size() > k) {
			minHeap.poll();
		}
		Traverse(root.right, k);
	}

}
