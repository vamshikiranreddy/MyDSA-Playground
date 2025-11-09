package Trees_6;

import java.util.*;

public class Max_Diffrence_Ancestor {
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
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		Print(root.left);
		Print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements [-1 for no elements]: ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre-Order]:-");
		Print(root);
		System.out.println();
		int Max_Diffrence = Max_Diff(root);
		System.out.println("The Max Diffrence B/W a Node And Ancestor Node is  " + Max_Diffrence);
		in.close();
	}

	public static int Max_Diff(TreeNode root) {
		return DFS(root,root.data,root.data);
	}

	public static int DFS(TreeNode root, int minVal, int maxVal) {
		if(root == null) return maxVal - minVal;
		
		minVal = Math.min(minVal, root.data);
		maxVal = Math.max(root.data, maxVal);
		
		int leftDiff = DFS(root.left,minVal,maxVal);
		int rightDiff = DFS(root.right,minVal,maxVal);
		return Math.max(leftDiff,rightDiff);
	}
}
