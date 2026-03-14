package Trees_7;

import java.util.*;

public class BurnBinaryTree {

	static int idx = -1;

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

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

	public static void PrintPreOrder(TreeNode root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		PrintPreOrder(root.left);
		PrintPreOrder(root.right);
	}

	public static TreeNode MapParents(TreeNode root, int start, Map<TreeNode, TreeNode> parentMap) {

		TreeNode targetNode = null;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {

			TreeNode curr = q.poll();

			if (curr.data == start)
				targetNode = curr;

			if (curr.left != null) {
				parentMap.put(curr.left, curr);
				q.offer(curr.left);
			}

			if (curr.right != null) {
				parentMap.put(curr.right, curr);
				q.offer(curr.right);
			}
		}

		return targetNode;
	}

	public static int BurnTree(TreeNode target, Map<TreeNode, TreeNode> parentMap) {

		int minTime = 0;

		Queue<TreeNode> q = new LinkedList<>();
		Set<TreeNode> visited = new HashSet<>();

		q.offer(target);
		visited.add(target);

		while (!q.isEmpty()) {

			int size = q.size();
			boolean burnt = false;

			for (int i = 0; i < size; i++) {

				TreeNode curr = q.poll();

				if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {

					burnt = true;
					visited.add(parentMap.get(curr));
					q.offer(parentMap.get(curr));
				}

				if (curr.left != null && !visited.contains(curr.left)) {

					burnt = true;
					visited.add(curr.left);
					q.offer(curr.left);
				}

				if (curr.right != null && !visited.contains(curr.right)) {

					burnt = true;
					visited.add(curr.right);
					q.offer(curr.right);
				}
			}

			if (burnt)
				minTime++;
		}

		return minTime;
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

		System.out.println("Enter Target Value : ");
		int start = in.nextInt();

		Map<TreeNode, TreeNode> parentMap = new HashMap<>();

		TreeNode target = MapParents(root, start, parentMap);

		int time = BurnTree(target, parentMap);

		System.out.println("Minimum Time To Burn Tree : " + time);

		in.close();
	}
}