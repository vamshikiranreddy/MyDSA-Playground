package Trees_2;

import java.util.*;

public class Build_tree_pos_in {
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
		int[] postorder = new int[size];
		System.out.println("Enter The elements for postorder");
		for (int i = 0; i < size; i++) {
			postorder[i] = in.nextInt();
		}
		int[] inorder = new int[size];
		System.out.println("Enter The elements for inorder");
		for (int i = 0; i < size; i++) {
			inorder[i] = in.nextInt();
		}
		TreeNode root = Construct(postorder, inorder);
		System.out.println("The Tree : ");
		print(root);
		in.close();
	}

	private static int postorder_idx;
	private static HashMap<Integer, Integer> in_idx_map;

	public static TreeNode Construct(int[] postorder, int[] inorder) {
		postorder_idx = inorder.length-1;
		in_idx_map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			in_idx_map.put(inorder[i], i);
		}
		int left = 0;
		int right = inorder.length - 1;
		return Construct_helper(postorder, left, right);
	}

	public static TreeNode Construct_helper(int[] postorder, int left, int right) {
		if (left > right) {
			return null;
		}
		int rootValue = postorder[postorder_idx--];
		TreeNode root = new TreeNode(rootValue);

		int middle = in_idx_map.get(rootValue);
		root.right = Construct_helper(postorder, middle + 1, right);
		root.left = Construct_helper(postorder, left, middle - 1);

		return root;
	}
}
