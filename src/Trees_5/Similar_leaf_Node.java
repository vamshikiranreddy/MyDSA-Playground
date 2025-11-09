package Trees_5;

import java.util.*;

public class Similar_leaf_Node {
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
		System.out.println("Enter The size for 1st tree");
		int size_1 = in.nextInt();
		int[] arr_1 = new int[size_1];
		System.out.println("Enter The Elements for 1st Tree (-1 for No Child)");
		for (int i = 0; i < size_1; i++) {
			arr_1[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root1 = Create(arr_1);
		System.out.println("The 1st Tree (Pre-Order)");
		Print(root1);
		System.out.println();
		System.out.println("Enter The size for 2nd tree ");
		int size_2 = in.nextInt();
		int[] arr_2 = new int[size_2];
		System.out.println("Enter The Elements for 2nd Tree (-1 for No Child)");
		for (int i = 0; i < size_2; i++) {
			arr_2[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root2 = Create(arr_2);
		System.out.println("The 2nd Tree (Pre-Order)");
		Print(root2);
		System.out.println();
		in.close();
		if(Is_Leaf_Similar(root1,root2)) {
			System.out.println("Yes The Two Trees Are Leaf-Similar");
		}else {
			System.out.println("No The Two Trees Are  Not Leaf-Similar");
		}
	}
	public static boolean Is_Leaf_Similar(TreeNode root1,TreeNode root2) {
		List<Integer> tree1 = new ArrayList<>();
		List<Integer> tree2 = new ArrayList<>();
		dfs(root1,tree1);
		dfs(root2,tree2);
		return tree1.equals(tree2);
	}

	public static void dfs(TreeNode root, List<Integer> list) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			list.add(root.data);
		}
		dfs(root.left,list);
	}
}
