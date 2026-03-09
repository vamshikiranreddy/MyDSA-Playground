package Trees_7;

import java.util.*;

public class All_Nodes_Within_A_Distance_Of_K {

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

	public static void PrintPreOrder(TreeNode root) {
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

		System.out.println("The Target is : " + root.left.data);
		TreeNode target = root.left; // for temp for leetcode it's diff

		System.out.println("Enter The Distance k : ");
		int k = in.nextInt();

		System.out.println("The Nodes With A Distance Of " + k);
		List<Integer> result = DistanceNodes(root, target, k);
		System.out.println(result);

		in.close();
	}

	private static List<Integer> DistanceNodes(TreeNode root, TreeNode target, int k) {

		Map<TreeNode, TreeNode> Parent_Track = new HashMap<>();
		ParentTrack(root, Parent_Track);

		Set<TreeNode> VisitedSet = new HashSet<>();
		Queue<TreeNode> q = new LinkedList<>();

		q.offer(target);
		VisitedSet.add(target);

		int currLevel = 0;

		while (!q.isEmpty()) {

			int size = q.size();
			if (currLevel == k)
				break;

			currLevel++;

			for (int i = 0; i < size; i++) {

				TreeNode curr = q.poll();

				// Parent
				if (Parent_Track.get(curr) != null && !VisitedSet.contains(Parent_Track.get(curr))) {
					q.offer(Parent_Track.get(curr));
					VisitedSet.add(Parent_Track.get(curr));
				}

				// left
				if (curr.left != null && !VisitedSet.contains(curr.left)) {
					q.offer(curr.left);
					VisitedSet.add(curr.left);
				}

				// right
				if (curr.right != null && !VisitedSet.contains(curr.right)) {
					q.offer(curr.right);
					VisitedSet.add(curr.right);
				}
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!q.isEmpty()) {
			result.add(q.poll().data);
		}

		return result;
	}

	private static void ParentTrack(TreeNode root, Map<TreeNode, TreeNode> parent_Track) {

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				TreeNode curr = q.poll();

				if (curr.left != null) {
					parent_Track.put(curr.left, curr);
					q.offer(curr.left);
				}

				if (curr.right != null) {
					parent_Track.put(curr.right, curr);
					q.offer(curr.right);
				}
			}
		}
	}
}