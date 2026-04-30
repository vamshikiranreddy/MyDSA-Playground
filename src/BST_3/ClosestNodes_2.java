package BST_3;

import java.util.*;

public class ClosestNodes_2 {

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// Insert into BST
	public static TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);

		if (val < root.val)
			root.left = insert(root.left, val);
		else
			root.right = insert(root.right, val);

		return root;
	}

	// 🔥 Inorder → sorted list
	public static void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}

	// 🔥 Optimized closest nodes
	public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

		List<Integer> sorted = new ArrayList<>();
		inorder(root, sorted);

		List<List<Integer>> result = new ArrayList<>();

		for (int x : queries) {

			int floor = -1, ceil = -1;

			int l = 0, r = sorted.size() - 1;

			while (l <= r) {
				int mid = (l + r) / 2;

				if (sorted.get(mid) == x) {
					floor = ceil = sorted.get(mid);
					break;
				} else if (sorted.get(mid) < x) {
					floor = sorted.get(mid);
					l = mid + 1;
				} else {
					ceil = sorted.get(mid);
					r = mid - 1;
				}
			}

			result.add(Arrays.asList(floor, ceil));
		}

		return result;
	}

	// Test
	public static void main(String[] args) {

		int[] values = { 10, 5, 1, 7, 40, 50 };
		TreeNode root = null;

		for (int v : values) {
			root = insert(root, v);
		}

		List<Integer> queries = Arrays.asList(0, 6, 10, 55);

		List<List<Integer>> ans = closestNodes(root, queries);

		for (List<Integer> pair : ans) {
			System.out.println(pair);
		}
	}
}