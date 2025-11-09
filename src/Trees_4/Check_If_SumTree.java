package Trees_4;

import java.util.*;

public class Check_If_SumTree {
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
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements [Pre-Order] -1 for no child");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre]");
		Print(root);
		System.out.println();
		if (CheckSum(root)) {
			System.out.println("The Tree Is Sum Tree");
		} else {
			System.out.println("The Tree Is Not Sum Tree");
		}
		in.close();
	}

	public static int Sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = Sum(root.left);
		int rightSum = Sum(root.right);
		return leftSum + rightSum + root.data;
	}

	public static boolean CheckSum(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		int leftSum = Sum(root.left);
		int rightSum = Sum(root.right);
		return (root.data == leftSum + rightSum) && CheckSum(root.left) && CheckSum(root.right);
	}
}
