package Trees_4;
import java.util.*;

import Trees_4.Lowest_Common_Ancestor.TreeNode;
public class Top_Veiw_BT {
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
	
	public static TreeNode Create(int[] arr) {
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
		System.out.println("Enter The size ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements (-1 for No Child)");
		for(int i = 0;i<size;i++) {
			arr[i] = in.nextInt();
		}
		idx=-1;
		TreeNode root = Create(arr);
		System.out.println("The Tree (Pre-Order)");
		Print(root);
		System.out.println();
		List<Integer> result = Top_View(root);
		System.out.println("The Top view Of The Binary Tree is ");
		for(int num : result) {
			System.out.print(num + " ");
		}
		in.close();

	}
	static class pair{
		int hd;
		TreeNode node;
		pair(int hd,TreeNode node){
			this.hd = hd;
			this.node = node;
		}
	}
		
	public static List<Integer> Top_View(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Map<Integer,Integer> map = new TreeMap<>();
		Queue<pair> queue = new LinkedList<>();
		queue.offer(new pair(0,root));
		while(!queue.isEmpty()) {
			pair current = queue.poll();
			if(!map.containsKey(current.hd)) {
				map.put(current.hd, current.node.data);
			}
			if(current.node.left != null) {
				queue.offer(new pair(current.hd-1,current.node.left));
			}
			if(current.node.right != null) {
				queue.offer(new pair(current.hd+1,current.node.right));
			}
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
}
