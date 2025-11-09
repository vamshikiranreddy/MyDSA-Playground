package Trees;

import java.util.*;

class Tree_Node {
	int data;
	Tree_Node left;
	Tree_Node right;

	Tree_Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Count_Nodes {

	static int idx = -1;

	public static Tree_Node buildTree(int[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		Tree_Node newNode = new Tree_Node(arr[idx]);
		newNode.left = buildTree(arr);
		newNode.right = buildTree(arr);
		return newNode;

	}

	public static void print(Tree_Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + "");
		print(root.left);
		print(root.right);
	}

	public static int CountOfNodes(Tree_Node root) {
		if (root == null)
			return 0;
		int leftNodes = CountOfNodes(root.left);
		int rightNodes = CountOfNodes(root.right);
		return leftNodes + rightNodes + 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size :");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		Tree_Node root = buildTree(arr);
		System.out.println("The Tree = ");
		print(root);
		int count = CountOfNodes(root);
		System.out.println("The Number Of Nodes are " + count);

		in.close();

	}

}
