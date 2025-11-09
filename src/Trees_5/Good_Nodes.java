package Trees_5;

import java.util.*;

public class Good_Nodes {
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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 forno child) : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre-Order] : ");
		Print(root);
		System.out.println();
		int good_nodes = Good_Node(root);
		System.out.println("The Number Of Good Nodes Are " + good_nodes);
		in.close();
	}

	private static int Good_Node(TreeNode root) {
		return dfs(root, root.data);
	}

	private static int dfs(TreeNode root, int MaxSoFar) {
		if (root == null) {
			return 0;
		}
		int good = 0;
		if (root.data >= MaxSoFar) {
			good = 1;
		}
		MaxSoFar = Math.max(MaxSoFar, root.data);

		good += dfs(root.left, MaxSoFar);
		good += dfs(root.right, MaxSoFar);
		return good;
	}
}
