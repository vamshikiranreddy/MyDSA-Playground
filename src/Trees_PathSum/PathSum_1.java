package Trees_PathSum;
import java.util.*;
public class PathSum_1 {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
			this.left = this.right = null;
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
	
	public static void Print(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		Print(root.left);
		Print(root.right);
	}
	
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size");
		int size = in.nextInt();
		int [] arr = new int[size];
		System.out.println("Enter The Elements (Pre-Order) -1 for no child");
		for(int  i = 0;i<size;i++) {
			arr[i] = in.nextInt();
		}
		idx = -1;
		TreeNode root  = Create(arr);
		System.out.println("The Tree");
		Print(root);
		System.out.println();
		System.out.println("The Taget Sum : ");
		int targetSum = in.nextInt();
		if(PathSum(root,targetSum)) {
			System.out.println("There Is A Path (root to leaf) with target Sum");
		}else {
			System.out.println("There Is no Path (root to leaf) with target Sum");
		}
		in.close();
	}
	
	public static boolean PathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		Stack<TreeNode> NodeStack = new Stack<>();
		Stack<Integer> SumStack = new Stack<>();
		NodeStack.push(root);
		SumStack.push(root.data);
		while(!NodeStack.isEmpty() && !SumStack.isEmpty()) {
			TreeNode tempNode = NodeStack.pop();
			int tempVal = SumStack.pop();
			if(tempVal == targetSum && tempNode.left == null && tempNode.right == null) {
				return true;
			}
			if(tempNode.left != null) {
				NodeStack.push(tempNode.left);
				SumStack.push(tempNode.left.data + tempVal);
			}if(tempNode.right != null) {
				NodeStack.push(tempNode.right);
				SumStack.push(tempNode.right.data + tempVal);
			}
		}
		return false;
	}
}
