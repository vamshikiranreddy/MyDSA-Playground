package Trees_5;

import java.util.*;

public class Even_Odd {
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
		System.out.println("Enter The Size Of The Array ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 for No Child)");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre-order]");
		Print(root);
		System.out.println();
		if (EvenOddCheck(root)) {
			System.out.println("Yes It Follows The Even Odd Check");
		} else {
			System.out.println("No  It Doesn't Follows The Even Odd Check");
		}
	}

	public static boolean EvenOddCheck(TreeNode root) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			TreeNode prevNode = null;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode currNode = queue.poll();
				if (level % 2 == 0) {
					if (currNode.data % 2 == 0) {
						return false;
					}
					if (prevNode != null && prevNode.data <= currNode.data) {
						return false;
					}
				} else {
					if (currNode.data % 2 == 1) {
						return false;
					}
					if (prevNode != null && prevNode.data >= currNode.data) {
						return false;
					}
				}
				prevNode = currNode;
				if (currNode.left != null) {
					queue.offer(currNode.left);
				}
				if (currNode.right != null) {
					queue.offer(currNode.right);
				}
			}
			level++;
		}
		return true;
	}

}
