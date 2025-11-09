package Trees_2;

import java.util.*;

public class Is_Symetric {
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
		
		public static TreeNode create(int arr []) {
			idx++;
			if(idx >= arr.length || arr[idx] == -1) {
				return null;
			}
			TreeNode newNode = new TreeNode(arr[idx]);
			newNode.left = create(arr);
			newNode.right = create(arr);
			return newNode;
		}
		
		public static void print(TreeNode root) {
			if(root == null) {
				return;
			}
			System.out.print(root.data + " ");
			print(root.left);
			print(root.right);
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter The Size ");
			int size = in.nextInt();
			int arr[] = new int[size];
			System.out.println("Enter The Elements (-1 for no child) ");
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			idx = -1;
			TreeNode root = create(arr);
			System.out.println("The Tree ");
			print(root);
			System.out.println();
			if(is_Symetric(root)) {
				System.out.println("True The Tree is Symetric ");
			}else {
				System.out.println("False The Tree is not  Symetric ");
			}
			in.close();
	}
		public static boolean is_Symetric(TreeNode root) {
			return isMirror(root.left,root.right);
		}
		public static boolean isMirror(TreeNode n1 , TreeNode n2) {
			if(n1 == null && n2 == null) {
				return true;
			}
			if(n1 == null || n2 == null) {
				return false;
			}
			return n1.data == n2.data && isMirror(n1.left,n2.right) && isMirror(n1.right,n2.left);
		}

}
