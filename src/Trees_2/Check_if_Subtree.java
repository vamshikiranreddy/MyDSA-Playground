package Trees_2;

import java.util.*;

public class Check_if_Subtree {
	static int idx = -1;

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

	private static TreeNode Create(int[] arr) {
		idx++;
		if(idx > arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}
	
	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data);
		print(root.left);
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The size for 1st tree");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Data (-1 for no child) ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter The size for 2nd  tree");
		int size_2 = in.nextInt();
		int[] arr_2 = new int[size_2];
		System.out.println("Enter The Data (-1 for no child) ");
		for (int i = 0; i < size_2; i++) {
			arr_2[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		idx = -1;
		TreeNode subroot = Create(arr);
		System.out.println("The 1st Tree");
		print(root);
		System.out.println();
		System.out.println("The 2nd Tree");
		print(subroot);
		System.out.println();

		if (isSubTree(root, subroot)) {
			System.out.println("The 2nd Tree is the sub tree of first Tree");
		} else {
			System.out.println("The 2nd Tree is not the sub tree of first Tree ");
		}
		in.close();
	}
	
	public static boolean isSubTree(TreeNode root,TreeNode subroot) {
		if(root == null) {
			return false;
		}
		if(root.data == subroot.data) {
			if(isIdentical(root,subroot)) {
				return true;
			}
		}
		return isSubTree(root.left,subroot) || isSubTree(root.right,subroot);
	}
	
	public static boolean isIdentical(TreeNode root,TreeNode subroot) {
		if(root == null && subroot == null) {
			return true;
		}else if(root == null || subroot == null || root.data != subroot.data) {
			return false;
		}
		if(!isIdentical(root.left,subroot.left)) {
			return false;
		}
		if(!isIdentical(root.right,subroot.right)) {
			return false;
		}
		return true;
	}

}
