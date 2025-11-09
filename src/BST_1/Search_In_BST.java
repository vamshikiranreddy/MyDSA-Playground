	package BST_1;
import java.util.*;
public class Search_In_BST {
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
	
	public static TreeNode insert(TreeNode root,int value) {
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		if(value < root.data) {
			root.left = insert(root.left,value);
		}else {
			root.right = insert(root.right,value);
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
	
	public static boolean search(TreeNode root,int key) {
		if(root == null) {
			return false;
		}
		if(key < root.data) {
			return search(root.left,key);
		}else if(root.data == key) {
			return true;
		}else {
			return search(root.right,key);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int [] nums = new int[size];
		System.out.println("Enter The Elements");
		for(int i = 0;i<size;i++) {
			nums[i] = in.nextInt();
		}
		
		TreeNode root = null;
		for(int i = 0;i<nums.length;i++) {
			root = insert(root,nums[i]);
		}
		print(root);
		System.out.println();
		System.out.println("Enter The Key to be searched ");
		int key = in.nextInt();
		if(search(root,key)) {
			System.out.println("Element is preset in the Tree");
		}else {
			System.out.println("Element is not preset in the Tree");
		}
		in.close();

	}

}
