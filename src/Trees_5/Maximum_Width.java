package Trees_5;

import java.util.*;

public class Maximum_Width {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static class Pair<K, V> {
		private final K key;
		private final V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	static int idx;

	public static TreeNode Create(int[] arr) {
		idx++;
		if (idx > arr.length || arr[idx] == -1) {
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
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter The elements (-1 for no child) ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree in Pre-Order ");
		Print(root);
		System.out.println();
		int max_width = Max_Width(root);
		System.out.println("The Maximum Width Of The Tree is " + max_width);
	}

	public static int Max_Width(TreeNode root) {
		if (root == null) {
			return -1;
		}
		Deque<Pair<TreeNode, Integer>> Q = new ArrayDeque<>();
		Q.offer(new Pair<>(root, 0));
		int max = 0;
		while (Q.isEmpty()) {
			int size = Q.size();
			int startIdx = Q.peekFirst().getValue();
			int endIdx = Q.peekLast().getValue();
			max = Math.max(max, endIdx - startIdx + 1);
			for (int i = 0; i < size; i++) {
				Pair<TreeNode, Integer> P = Q.poll();
				TreeNode node = P.getKey();
				int idx = P.getValue();
				if (node.left != null) {
					Q.offer(new Pair<>(node.left, 2 * idx + 1));
				}
				if (node.right != null) {
					Q.offer(new Pair<>(node.right, 2 * idx + 2));
				}
			}
		}

		return max;
	}

}
