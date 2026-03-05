package Trees_6;

import java.util.*;

public class Boundary_Traversal {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static int idx = -1;

	private static TreeNode Create(int[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1)
			return null;

		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}

	private static void PrintPreOrder(TreeNode root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		PrintPreOrder(root.left);
		PrintPreOrder(root.right);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("The Size : ");
		int size = in.nextInt();

		int[] arr = new int[size];

		System.out.println("The Values Of The Node : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}

		idx = -1;
		TreeNode root = Create(arr);

		System.out.println("The Tree (Pre-Order) :- ");
		PrintPreOrder(root);
		System.out.println();

		System.out.println("The Boundary-Traversal of The Binary Tree :- ");

		List<Integer> Boundary = BoundaryTraversal(root);

		for (int num : Boundary) {
			System.out.print(num + " ");
		}

		in.close();
	}

	private static List<Integer> BoundaryTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();

		if (root == null)
			return res;

		if (!isLeaf(root))
			res.add(root.data);

		AddLeftBoundary(root, res);
		AddLeafs(root, res);
		AddRightBoundary(root, res);

		return res;
	}

	static boolean isLeaf(TreeNode root) {
		if (root == null)
			return false;

		return root.left == null && root.right == null;
	}

	private static void AddLeftBoundary(TreeNode root, List<Integer> res) {

		TreeNode curr = root.left;

		while (curr != null) {

			if (!isLeaf(curr)) {
				res.add(curr.data);
			}

			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
	}

	private static void AddLeafs(TreeNode root, List<Integer> res) {

		if (root == null)
			return;

		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}

		AddLeafs(root.left, res);
		AddLeafs(root.right, res);
	}

	private static void AddRightBoundary(TreeNode root, List<Integer> res) {

		List<Integer> rightTr = new ArrayList<>();

		TreeNode curr = root.right;

		while (curr != null) {

			if (!isLeaf(curr)) {
				rightTr.add(curr.data);
			}

			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}

		for (int i = rightTr.size() - 1; i >= 0; i--) {
			res.add(rightTr.get(i));
		}
	}

}
