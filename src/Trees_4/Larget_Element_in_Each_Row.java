package Trees_4;

import java.util.*;

public class Larget_Element_in_Each_Row {
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
		int[] arr = new int[size];
		System.out.println("Enter The Elements [Pre-Order] -1 for no child");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre]");
		Print(root);
		System.out.println();
		List<Integer> result = LER(root);
		System.out.println(result);
		in.close();
	}

	private static List<Integer> LER(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp.data > max) {
					max = temp.data;
				}
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			result.add(max);
		}
		return result;
	}
}
