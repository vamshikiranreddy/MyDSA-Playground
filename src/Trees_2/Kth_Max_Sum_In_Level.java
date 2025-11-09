package Trees_2;

import java.util.*;

public class Kth_Max_Sum_In_Level {
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
	
	public static void print(TreeNode root) {
		if(root == null) {
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
		int[] arr = new int[size];
		System.out.println("Enter The Elements");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree [Pre-Order] ");
		print(root);
		System.out.println();
		System.out.println("Enter The k value ");
		int k = in.nextInt();
		int kth_max_level_Sum = max_sum(root,k);
		System.out.println("The kth Max level Sum is " + kth_max_level_Sum);
		in.close();

	}
	public static int max_sum(TreeNode root,int k) {
		if(root == null) {
			return -1;
		}
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()) {
			int size = Q.size();
			int sum = 0;
			for(int i = 0;i<size;i++) {
				TreeNode current = Q.poll();
				sum += current.data;
				if(current.left != null) {
					Q.add(current.left);
				}
				if(current.right != null) {
					Q.add(current.right);
				}
			}
			PQ.add(sum);
			if(PQ.size() > k) {
				PQ.poll();
			}
		}
		return PQ.peek();
	}

}
