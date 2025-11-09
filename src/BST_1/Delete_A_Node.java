package BST_1;

import java.util.*;


public class Delete_A_Node {
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

	public static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
	}

	public static TreeNode insert(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		if (value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter The Elements");
		for (int i = 0; i < size; i++) {
			nums[i] = in.nextInt();
		}
		TreeNode root = null;
		for (int i = 0; i < nums.length; i++) {
			root = insert(root, nums[i]);
		}
		print(root);
		System.out.println();
		System.out.println("Enter The Value to be Deleted");
		int value = in.nextInt();
		delete(root, value);
		System.out.println("Tree After Deletion");
		print(root);
		System.out.println();
		in.close();

	}

	public static TreeNode delete(TreeNode root, int value) {
		// searching for the root to delete
		if (value < root.data) {
			root.left = delete(root.left, value);
		} else if (value > root.data) {
			root.right = delete(root.right, value);
		} else {
			// case 1 = no child
			if(root.left == null && root.right == null) {
				return null;
			}
			// case 2 = one child 
			if(root.left == null) {
				return root.right;
			}else if(root.right == null){
				return root.left;
			}
			// case 3 = two children
			TreeNode Is = inorderSucessor(root.right);
			root.data = Is.data;
			root.right = delete(root.right,Is.data);
			
		}
		return root;
	}
	public static TreeNode inorderSucessor(TreeNode root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}

}
