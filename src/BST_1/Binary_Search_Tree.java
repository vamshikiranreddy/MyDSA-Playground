package BST_1;

import java.util.*;

public class Binary_Search_Tree {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode (int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array");
		int size = in.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter The Elements : ");
		for(int i = 0;i<size;i++) {
			nums[i] = in.nextInt();
		}
		TreeNode root = null;
		for(int i = 0;i<nums.length;i++) {
			root = insert(root,nums[i]);
		}
		System.out.println("The BST is");
		print(root);
		System.out.println();
		in.close();

	}
	
	public static TreeNode insert(TreeNode root,int value) {
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		if(root.data < value) {
			root.right = insert(root.right,value);
		}else {
			root.left = insert(root.left,value);
		}
		return root;
	}

}
