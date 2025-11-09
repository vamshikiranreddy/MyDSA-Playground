package Trees_2;

import java.util.*;

public class Right_Side_Veiw {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static int idx = -1;
	
	public static TreeNode Create(int [] arr) {
		idx++;
		if(idx > arr.length || arr[idx] == -1) {
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
		System.out.println(root.data + " ");
		print(root.left);
		print(root.right);
	}
	
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size :");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		TreeNode root = Create(arr);
		System.out.println("The Tree [PreOrder] ");
		print(root);
		List <Integer> result = Right_Side_Veiw(root);
		System.out.println("The Right Side Veiw ");
		for(int num : result) {
			System.out.print(num + " ");
		}
		in.close();
	}
	public static List<Integer> Right_Side_Veiw(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		while(!Q.isEmpty()) {
			int size  = Q.size();
			for(int i = 0;i<size;i++) {
				TreeNode current = Q.poll();
				if(i == 0) {
					result.add(current.data);
				}
				if(current.right != null) { // for left side veiw just add left child node
					Q.add(current.right);
				}
				if(current.left != null) {
					Q.add(current.left);
				}
			}
		}
		return result;
	}
}
