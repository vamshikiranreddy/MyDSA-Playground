package Trees_3;

import java.util.*;

public class Minimum_Absolute_Diff {
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
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Data in Pre-Ordeder (-1 for no Child)");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree [pre-order]");
		print(root);
		System.out.println();
		int absolute_diff = abs(root);
		System.out.println("The Absolute Diffrence is " + absolute_diff);
		in.close();
	}

	public static int abs(TreeNode root) {
		if (root == null) {
			return -1;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		TreeNode prev = null;
		int result = Integer.MAX_VALUE;
		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				if (prev != null) {
					result = Math.min(result, Math.abs(prev.data - current.data));
				}
				prev = current;
				current = current.right;
			}
		}
		return result;
	}
}
