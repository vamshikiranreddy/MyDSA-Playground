package BST_3;

import java.util.*;

public class Ceil {

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

	// Insert into BST
	public static TreeNode Insert(TreeNode root, int num) {
		if (root == null) {
			return new TreeNode(num);
		}

		if (num < root.data) {
			root.left = Insert(root.left, num);
		} else {
			root.right = Insert(root.right, num);
		}
		return root;
	}

	// Inorder traversal
	private static void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// 🔥 Iterative Ceil Function (NO recursion)
	public static int findCeil(TreeNode root, int x) {
		int ceil = -1;

		while (root != null) {
			if (root.data == x) {
				return root.data;
			} else if (root.data < x) {
				root = root.right;
			} else {
				ceil = root.data; // store candidate
				root = root.left;
			}
		}

		return ceil;
	}

	public static void main(String[] args) {

		int[] values = { 10, 5, 1, 7, 40, 50 };

		TreeNode root = null;

		for (int val : values) {
			root = Insert(root, val);
		}

		System.out.print("Inorder Traversal of BST: ");
		inorder(root);
		System.out.println();

		int x = 6;
		int ceil = findCeil(root, x);

		System.out.println("Ceil of " + x + " is: " + ceil);
	}
}