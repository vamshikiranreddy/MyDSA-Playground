package Trees_4;
import java.util.*;
public class Lowest_Common_Ancestor {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static int idx = -1;
	
	public static TreeNode Create(int [] arr) {
		idx++;
		if(idx >= arr.length || arr[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(arr[idx]);
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
		
	}
	
	public static TreeNode LCA(TreeNode root,TreeNode p,TreeNode q) {
		if(root == null) {
			return null;
		}
		if(root.data == p.data || root.data == q.data) {
			return root;
		}
		
		TreeNode RightLCA = LCA(root.left,p,q);
		TreeNode LeftLCA = LCA(root.right,p,q);
		
		if(RightLCA != null && LeftLCA != null) {
			return root;
		}else if(LeftLCA !=null) {
			return LeftLCA;
		}else {
			return RightLCA;
		}
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
		System.out.println("Enter The size ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 for No Child)");
		for(int i = 0;i<size;i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root = Create(arr);
		System.out.println("The Tree (Pre-Order)");
		Print(root);
		System.out.println();
		System.out.println("Enter The P Value");
		TreeNode p = null;
		p.data = in.nextInt();
		TreeNode q = null;
		q.data = in.nextInt();
		TreeNode result =  LCA(root,p,q);
		System.out.println("The Lowest Common Ancestor is " + result.data);
		in.close();
	}
}
