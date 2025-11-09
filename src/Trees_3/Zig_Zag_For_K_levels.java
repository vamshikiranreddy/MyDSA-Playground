package Trees_3;

import java.util.*;

public class Zig_Zag_For_K_levels {
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

	private static TreeNode Create(int[] arr) {
		idx++;
		if (idx > arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}

	private static void print(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data);
		print(root.left);
		print(root.right);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size ");
		int size = in.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter The Elements (-1 for no child) ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre-Order]");
		print(root);
		System.out.println();
		System.out.println("Enter The K levels");
		int k = in.nextInt();
		List<List<Integer>> result = Zig_Zag_Traversal(root,k);
		for (List<Integer> list : result) {
			System.out.print(list);
		}
		in.close();
	}

	public static List<List<Integer>> Zig_Zag_Traversal(TreeNode root,int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> Q = new LinkedList<>();
		Q.offer(root);
		boolean LeftToRight = true;
		int level_Count = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode current = Q.poll();
				if (LeftToRight) {
					list.addLast(current.data);
				} else {
					list.addFirst(current.data);
				}
				if (current.left != null) {
					Q.offer(current.left);
				}
				if (current.right != null) {
					Q.offer(current.right);
				}
			}
			result.add(list);
			level_Count++;
			if(level_Count % k == 0) {
				LeftToRight = !LeftToRight;
				level_Count = 0;
			}
			
		}
		return result;
	}
}
