package Trees_4;
import java.util.*;

import Trees_4.Lowest_Common_Ancestor.TreeNode;
public class Merge_Two_Trees {
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
	
	public static TreeNode Create (int [] arr) {
		idx++;
		if(idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}
	
	public static void Print(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		Print(root.left);
		Print(root.right);
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The size for 1st tree");
		int size_1 = in.nextInt();
		int[] arr_1 = new int[size_1];
		System.out.println("Enter The Elements for 1st Tree (-1 for No Child)");
		for(int i = 0;i<size_1;i++) {
			arr_1[i] = in.nextInt();
		}
		idx =-1;
		TreeNode root1 = Create(arr_1);
		System.out.println("The 1st Tree (Pre-Order)");
		Print(root1);
		System.out.println();
		System.out.println("Enter The size for 2nd tree ");
		int size_2 = in.nextInt();
		int[] arr_2 = new int[size_2];
		System.out.println("Enter The Elements for 2nd Tree (-1 for No Child)");
		for(int i = 0;i<size_2;i++) {
			arr_2[i] = in.nextInt();
		}
		idx =-1;
		TreeNode root2 = Create(arr_2);
		System.out.println("The 2nd Tree (Pre-Order)");
		Print(root2);
		System.out.println();
		TreeNode merged_Tree = mergeTrees(root1,root2);
		System.out.println("The Tree After Merging");
		Print(merged_Tree);
		in.close();

	}

	private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null) {
			return root2;
		}
		if(root2 == null) {
			return root1;
		}
		TreeNode newNode = new TreeNode(root1.data+root2.data);
		newNode.left = mergeTrees(root1.left,root2.left);
		newNode.right = mergeTrees(root1.right,root2.right);
		return newNode;
	}

}
