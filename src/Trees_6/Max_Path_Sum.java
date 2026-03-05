package Trees_6;

import java.util.*;

public class Max_Path_Sum {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static int idx = -1;

	private static TreeNode Create(int[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1)
			return null;

		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}

	private static void PrintPreOrder(TreeNode root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		PrintPreOrder(root.left);
		PrintPreOrder(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("The Size : ");
		int size = in.nextInt();

		int[] arr = new int[size];

		System.out.println("The Values Of The Node : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}

		idx = -1;
		TreeNode root = Create(arr);

		System.out.println("The Tree (Pre-Order) :- ");
		System.out.println("The Boundary-Traversal of The Binary Tree :- ");
		PrintPreOrder(root);
		System.out.println();

		int maxPathSum = MaxPath(root);
		System.out.println("The Maximum PathSum is : " + maxPathSum);

		in.close();
	}

	static int maxSum = Integer.MIN_VALUE;

	private static int MaxPath(TreeNode root) {
		DFS(root);
		return maxSum;
	}

	private static int DFS(TreeNode root) {
		if (root == null)
			return 0;

		int leftSum = Math.max(0, DFS(root.left));
		int rightSum = Math.max(0, DFS(root.right));

		// for updation of maximum sum
		maxSum = Math.max(maxSum, leftSum + rightSum + root.data);

		// Continuation of Path
		return root.data + Math.max(leftSum, rightSum);
	}

}
