package Trees;

import java.util.*;

class Tree_node_1 {
	int data;
	Tree_node_1 left;
	Tree_node_1 right;

	Tree_node_1(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Sum_Of_All_Nodes {
	static int idx = -1;

	public static Tree_node_1 Create(int[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		Tree_node_1 newNode = new Tree_node_1(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 for no child) :");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		Tree_node_1 root = Create(arr);
		int sum = Sum_Nodes(root);
		System.out.println("The Sum Of All The Nodes Are  " + sum);
		in.close();

	}

	public static int Sum_Nodes(Tree_node_1 root) {
		if (root == null) {
			return 0;
		}
		int leftSum = Sum_Nodes(root.left);
		int rightSum = Sum_Nodes(root.right);
		return leftSum + rightSum + root.data;
	}

}

