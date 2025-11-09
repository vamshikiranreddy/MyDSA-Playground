package Trees;

import java.util.*;

public class Diameter {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static int idx = -1;
	
	public static TreeNode create(int arr []) {
		idx++;
		if(idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = create(arr);
		newNode.right = create(arr);
		return newNode;
	}
	
	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size ");
		int size = in.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter The Elements (-1 for no child) ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = create(arr);
		System.out.println("The Tree ");
		print(root);
		System.out.println();
		int diameter = max_diameter(root);
		System.out.println("The maximum diameter of the binary tree is " + diameter);
		in.close();

	}
	public static int maxDiameter = 0;
	public static int max_diameter(TreeNode root) {
		height(root);
		return maxDiameter;
	}
	public static int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left_height = height(root.left);
		int right_height = height(root.right);
		maxDiameter = Math.max(maxDiameter, left_height + right_height);
		return Math.max(left_height, right_height) + 1;
	}

}
