package Trees_6;

import java.util.*;

public class Vertical_Traversal {

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

	static class Truple {
		int row;
		int col;
		TreeNode node;

		Truple(int row, int col, TreeNode node) {
			this.row = row;
			this.col = col;
			this.node = node;
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

	private static List<List<Integer>> verticalTraversal(TreeNode root) {

		Queue<Truple> q = new LinkedList<>();

		Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

		List<List<Integer>> result = new ArrayList<>();

		q.offer(new Truple(0, 0, root));

		while (!q.isEmpty()) {

			Truple curr = q.poll();

			int currRow = curr.row;
			int currCol = curr.col;
			TreeNode currNode = curr.node;

			map.putIfAbsent(currCol, new TreeMap<>());
			map.get(currCol).putIfAbsent(currRow, new PriorityQueue<>());

			map.get(currCol).get(currRow).offer(currNode.data);

			if (currNode.left != null) {
				q.offer(new Truple(currRow + 1, currCol - 1, currNode.left));
			}

			if (currNode.right != null) {
				q.offer(new Truple(currRow + 1, currCol + 1, currNode.right));
			}
		}

		for (Map<Integer, PriorityQueue<Integer>> m : map.values()) {

			List<Integer> list = new ArrayList<>();

			for (PriorityQueue<Integer> pq : m.values()) {

				while (!pq.isEmpty()) {
					list.add(pq.poll());
				}
			}

			result.add(list);
		}

		return result;
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

		List<List<Integer>> ans = verticalTraversal(root);

		System.out.println("Vertical Traversal :- ");
		for (List<Integer> list : ans) {
			System.out.println(list);
		}

		in.close();
	}
}