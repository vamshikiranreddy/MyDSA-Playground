package Trees_3;
import java.util.*;
public class Build_Tree_SortedArray {
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
	public static void print(TreeNode root) {
		if(root == null) {
			return;
		}
		print(root.left);
		System.out.print(root.data +" ");
		print(root.right);
	}
	public static TreeNode Build_BST(int [] nums) {
		if(nums.length == 0) {
			return null;
		}
		int left = 0;
		int right = nums.length-1;
		return BST_Helper(nums,left,right);
	}
	public static TreeNode BST_Helper(int [] nums,int left,int right) {
		if(left > right) {
			return null;
		}
		int middle = left + (right-left)/2;
		TreeNode root = new TreeNode(nums[middle]);
		root.left = BST_Helper(nums,left,middle-1);
		root.right = BST_Helper(nums,middle+1,right);
		return root;
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int nums[] = new int[size];
		System.out.println("ENter The Elements in Sorted Manner");
		for(int i = 0;i<size;i++) {
			nums[i] = in.nextInt();
		}
		TreeNode root = Build_BST(nums);
		System.out.println("The Tree [In-Order]");
		print(root);
		System.out.println();
		if(isBalenced(root)) {
			System.out.println("The Tree Is Balenced");
		}else {
			System.out.println("The Tree Is Not Balenced");
		}
		in.close();
	}
	public static boolean isBalenced(TreeNode root) {
		if(root == null) {
			return true;
		}
		boolean [] flag = new boolean[1];
		Arrays.fill(flag,true);
		height(root,flag);
		return flag[0];
	}
	public static int height(TreeNode root,boolean [] flag) {
		if(root == null) {
			return 0;
		}
		int left_height = height(root.left,flag);
		int right_height = height(root.right,flag);
		if(Math.abs(right_height - left_height) > 1) {
			flag[0] = true;
		}
		return Math.max(left_height, right_height) +1;
	}
}
