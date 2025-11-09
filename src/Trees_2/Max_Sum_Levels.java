package Trees_2;

import java.util.*;

public class Max_Sum_Levels {
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

	static int idx = -1;

	public static TreeNode create(int arr[]) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = create(arr);
		newNode.right = create(arr);
		return newNode;
	}

	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size :");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		TreeNode root = create(arr);
		System.out.println("The Tree ");
		print(root);
		System.out.println();
		int maxSum = max_level_sum(root);
		System.out.println("Maximum level sum: " + maxSum);
		in.close();
	}

	public static int max_level_sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxSum = Integer.MIN_VALUE;
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);

		while (!Q.isEmpty()) {
			int size = Q.size();
			int levelSum = 0;

			for (int i = 0; i < size; i++) {
				TreeNode curr = Q.poll();
				levelSum += curr.data;
				if (curr.left != null) {
					Q.add(curr.left);
				}
				if (curr.right != null) {
					Q.add(curr.right);
				}
			}

			if (levelSum > maxSum) {
				maxSum = levelSum;
			}
		}
		return maxSum;
	}
}
