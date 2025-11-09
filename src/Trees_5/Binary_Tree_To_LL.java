package Trees_5;

import java.util.*;

public class Binary_Tree_To_LL {
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

	static int idx;

	public static TreeNode Create(int[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}

	public static void Print(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		Print(root.left);
		Print(root.right);
		
	}
	
	public static void PrintLinkedList(TreeNode root) {
	    while (root != null) {
	        System.out.print(root.data + " ");
	        root = root.right;
	    }
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The size ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 for No Child)");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree (Pre-Order)");
		Print(root);
		System.out.println();
		root = Flatten(root);
		System.out.println("The Flattened Tree : ");
		PrintLinkedList(root);
		in.close();
	}
	
	static TreeNode temp = null;
	
	private static  TreeNode Flatten(TreeNode root) {
		if(root == null) {
			return null;
		}
		Flatten(root.right);
		Flatten(root.left);
		
		root.left = null;
		root.right = temp;
		temp = root;
		return root;
	}
}
