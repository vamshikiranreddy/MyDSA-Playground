package BST_1;

import java.util.*;

public class Print_Range {
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

	public static TreeNode Create(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		if (value < root.data) {
			root.left = Create(root.left, value);
		} else {
			root.right = Create(root.right, value);
		}
		return root;
	}

	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.println(root.data + " ");
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter The Elements");
		for (int i = 0; i < size; i++) {
			nums[i] = in.nextInt();
		}
		TreeNode root = null;
		for (int i = 0; i < nums.length; i++) {
			root = Create(root, nums[i]);
		}
		System.out.println("The Tree [InOrder] ");
		print(root);
		System.out.println("Enter The Start range");
		int start = in.nextInt();
		System.out.println("Enter The End range ");
		int end = in.nextInt();
		Print_Range(root, start, end);
		in.close();
	}

	public static void Print_Range(TreeNode root, int start, int end) {
		if(root == null) {
			return;
		}
		// Traverse left subtree if there's a chance nodes are in range
	    if (start < root.data) {
	        Print_Range(root.left, start, end);
	    }
	    // If current node is in range, print it
	    if (root.data >= start && root.data <= end) {
	        System.out.println(root.data + " ");
	    }
	 // Traverse right subtree if there's a chance nodes are in range
	    if (root.data < end) {
	        Print_Range(root.right, start, end);
	    }
	}

}
