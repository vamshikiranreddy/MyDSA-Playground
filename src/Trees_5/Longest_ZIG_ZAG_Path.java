package Trees_5;

import java.util.*;

public class Longest_ZIG_ZAG_Path {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static class CheckNode {
		TreeNode node;
		int direction;
		int length;

		CheckNode(TreeNode node, int direction, int length) {
			this.node = node;
			this.direction = direction;
			this.length = length;
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
		System.out.print(root.data + "  ");
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
		int max_path = Zig_Zag(root);
		System.out.println("The Maximum Zig-Zag Path Of The Tree is " + max_path);
		in.close();
	}

	private static int Zig_Zag(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<CheckNode> queue = new LinkedList<>();
		int max = 0;
		// 0-left 1-Right
		if (root.left != null) {// left
			queue.offer(new CheckNode(root, 0, 1));
		}
		if (root.right != null) {// right
			queue.offer(new CheckNode(root, 1, 1));
		}
		while (!queue.isEmpty()) {
			CheckNode temp = queue.poll();
			max = Math.max(max, temp.length);
			if (temp.direction == 0) {// if already left
				if (temp.node.right != null) {
					queue.offer(new CheckNode(temp.node.right, 1, temp.length + 1));
				}
				if (temp.node.left != null) {
					queue.offer(new CheckNode(temp.node.left, 0, 1));
				}
			} else {
				if (temp.node.left != null) {
					queue.offer(new CheckNode(temp.node.left, 0, temp.length + 1));
				}
				if (temp.node.right != null) {
					queue.offer(new CheckNode(temp.node.right, 1, 1));
				}
			}
		}
		return max;
	}
}
