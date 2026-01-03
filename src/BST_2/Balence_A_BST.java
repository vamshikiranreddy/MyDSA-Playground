package BST_2;

import java.util.*;

public class Balence_A_BST {
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

	private static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

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
		
	    TreeNode balancedRoot = balanceBST(root);

	    System.out.print("Inorder Traversal of Height Balanced BST: ");
	    inorder(balancedRoot);
	}

	public static TreeNode balanceBST(TreeNode root) {
		List<Integer> Sorted = new ArrayList<>();
		InOrderRecursion(root, Sorted);
		TreeNode newTree = BalenceTree(Sorted, 0, Sorted.size() - 1);
		return newTree;
	}

	public static TreeNode BalenceTree(List<Integer> Sorted, int left, int right) {
		if (left > right)
			return null;

		int middle = left + (right - left) / 2;
		TreeNode newNode = new TreeNode(Sorted.get(middle));
		newNode.left = BalenceTree(Sorted, left, middle - 1);
		newNode.right = BalenceTree(Sorted, middle + 1, right);
		return newNode;
	}

	public static void InOrderRecursion(TreeNode root, List<Integer> Sorted) {
		if (root == null)
			return;
		InOrderRecursion(root.left, Sorted);
		Sorted.add(root.data);
		InOrderRecursion(root.right, Sorted);
	}

}
