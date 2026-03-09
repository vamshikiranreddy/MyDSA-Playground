package Trees_7;

import java.util.*;

public class Print_Root_Leaf {

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

		System.out.println("All The Paths From Root To Leaf : ");
		List<List<Integer>> result = RootToLeaf(root);

		System.out.println(result);

		in.close();
	}

	private static List<List<Integer>> RootToLeaf(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		RecursiveBackTrack(root, new ArrayList<>(), result);
		return result;
	}

	private static void RecursiveBackTrack(TreeNode root, ArrayList<Integer> tempList, List<List<Integer>> result) {

		if (root == null)
			return;

		tempList.add(root.data);

		if (root.left == null && root.right == null) {
			result.add(new ArrayList<>(tempList));
		} else {
			RecursiveBackTrack(root.left, tempList, result);
			RecursiveBackTrack(root.right, tempList, result);
		}

		tempList.remove(tempList.size() - 1);
	}
}