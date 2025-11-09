package Trees;

import java.util.*;

public class Level_order_revrerse {
	static int idx = -1;
	
	static class Tree_Node {
		int data;
		Tree_Node left;
		Tree_Node right;

		Tree_Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	public static Tree_Node Create(int[] arr) {
		idx++;
		if (idx > arr.length || arr[idx] == -1) {
			return null;
		}
		Tree_Node newNode = new Tree_Node(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}
	
	public static void print(Tree_Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array");
		int size = in.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter The Elements (-1 for No child) ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		Tree_Node root = Create(arr);
		System.out.println("The Tree is ");
		print(root);
		System.out.println("The Reverse-Level-Order Traversal is ");
		List<List<Integer>> result = rev_level_order(root);
		for(List<Integer> list : result) {
			System.out.print(list);
		}
		in.close();
	}
	
	public static List<List<Integer>> rev_level_order(Tree_Node root){
		List<List<Integer>> result = new LinkedList<>();
		if(root == null) {
			return result;
		}
		Queue<Tree_Node> Q = new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = Q.size();
			for(int i = 0;i<size;i++) {
				Tree_Node current = Q.poll();
				list.add(current.data);
				if(current.left != null) {
					Q.add(current.left);
				}
				if(current.right != null) {
					Q.add(current.right);
				}
			}
			result.addFirst(list);
		}
		return result;
	}

}
                                                   