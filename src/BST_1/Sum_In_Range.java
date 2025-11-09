package BST_1;
import java.util.*;
public class Sum_In_Range {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static TreeNode Insert(TreeNode root,int value) {
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		if(value < root.data) {
			root.right = Insert(root.left,value);
		}else {
			root.left = Insert(root.right,value);
		}
		return root;
	}
	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int[] nums = new int[size];
		System.out.println("Enter The Elements");
		for (int i = 0; i < size; i++) {
			nums[i] = in.nextInt();
		}
		TreeNode root = null;
		for(int i = 0;i<nums.length;i++) {
			root = Insert(root,nums[i]);
		}
		System.out.println("The BST [Inorder] :");
		print(root);
		System.out.println("Enter The Start Range");
		int start = in.nextInt();
		System.out.println("Enter The End Range");
		int end = in.nextInt();
		int sum = Range_Sum(root,start,end);
		System.out.println("The Sum Of Elements Form" + start + " to " + end + " is " + sum);
		in.close();
	}
	public static int Range_Sum(TreeNode root,int start,int end) {
		int sum = 0;
		if(root == null) {
			return 0;
		}
		if(start < root.data) {
			sum += Range_Sum(root.left,start,end);
		}
		if(root.data >= start && root.data <= end) {
			sum += root.data;
		}
		if(end > root.data) {
			sum += Range_Sum(root.right,start,end);
		}
		return sum;
	}
}
