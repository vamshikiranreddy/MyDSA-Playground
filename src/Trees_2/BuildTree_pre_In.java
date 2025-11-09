package Trees_2;

import java.util.*;

public class BuildTree_pre_In {
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
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array ");
		int size = in.nextInt();
		int[] preorder = new int[size];
		System.out.println("Enter The elements for preorder");
		for (int i = 0; i < size; i++) {
			preorder[i] = in.nextInt();
		}
		int[] inorder = new int[size];
		System.out.println("Enter The elements for inorder");
		for (int i = 0; i < size; i++) {
			inorder[i] = in.nextInt();
		}
		TreeNode root = Construct(preorder, inorder);
		System.out.println("The Tree : ");
		print(root);
		in.close();
	}

	private static int preorder_idx = 0;
	private static HashMap<Integer, Integer> in_idx_map;

	public static TreeNode Construct(int[] preorder, int[] inorder) {
		in_idx_map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			in_idx_map.put(inorder[i], i);
		}
		int left = 0;
		int right = inorder.length - 1;
		return Construct_helper(preorder,left,right);
	}
	
	public static TreeNode Construct_helper(int[] preorder,int left,int right) {
		if(left > right) {
			return null;
		}
		int rootValue = preorder[preorder_idx++];
		TreeNode root = new TreeNode(rootValue);
		
		int middle = in_idx_map.get(rootValue);
		
		root.left = Construct_helper(preorder,left,middle-1);
		root.right = Construct_helper(preorder,middle+1,right);
		return root;
	}
}
