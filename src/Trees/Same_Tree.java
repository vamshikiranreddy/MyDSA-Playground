package Trees;

import java.util.Scanner;

public class Same_Tree {
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
		System.out.println("Enter The Size for 1st tree");
		int size = in.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter The Elements (-1 for no child) ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter The Size for 2nd tree");
		int size_2 = in.nextInt();
		int arr_2[] = new int[size_2];
		System.out.println("Enter The Elements (-1 for no child) ");
		for (int i = 0; i < size_2; i++) {
			arr_2[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root_1 = create(arr);
		idx = -1;
		TreeNode root_2 = create(arr_2);
		System.out.println("The 1st Tree ");
		print(root_1);
		System.out.println();
		System.out.println("The 2nd Tree ");
		print(root_2);
		System.out.println();
		if(isSameTree(root_1,root_2)) {
			System.out.println("The Trees are similar");
		}else {
			System.out.println("The Trees are not similar");
		}
		
	}
	
	public static boolean isSameTree(TreeNode root_1 , TreeNode root_2) {
		if(root_1 == null && root_2 == null) {
			return true;
		}
		if(root_1 == null || root_2 == null || root_1.data != root_2.data) {
			return false;
		}
		return isSameTree(root_1.left,root_2.left) && isSameTree(root_1.right,root_2.right);
	}

}
