package Trees_PathSum;
import java.util.*;

import Trees_PathSum.PathSum_1.TreeNode;
public class Path_Sum_2 {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
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
		List<List<Integer>> result = PathSumList(root,targetSum);
		for(List<Integer> list : result) {
			System.out.println(list);
		}
 		in.close();
	}
	
	public static List<List<Integer>> PathSumList(TreeNode root,int targetSum){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Stack<TreeNode> NodeStack = new Stack<>();
		Stack<Integer> SumStack = new Stack<>();
		Stack<List<Integer>> ListStack = new Stack<>();
		NodeStack.push(root);
		SumStack.push(root.data);
		ListStack.push(new ArrayList<>(List.of(root.data)));
		while(!NodeStack.isEmpty()) {
			TreeNode tempNode =  NodeStack.pop();
			int tempVal = SumStack.pop();
			List<Integer> tempList = ListStack.pop();
			if(tempVal == targetSum && tempNode.left == null && tempNode.right == null){
				result.add(tempList);
			}
			if(tempNode.left != null) {
				NodeStack.push(tempNode.left);
				SumStack.push(tempVal + tempNode.left.data);
				List<Integer> newPath = new ArrayList<>(tempList);
				newPath.add(tempNode.left.data);
				ListStack.push(newPath);
			}
			if(tempNode.right != null) {
				NodeStack.push(tempNode.right);
				SumStack.push(tempNode.right.data + tempVal);
				List<Integer> newPath = new ArrayList<>(tempList);
				newPath.add(tempNode.right.data);
				ListStack.push(newPath);
			}
		}
		return result;
	}
}
