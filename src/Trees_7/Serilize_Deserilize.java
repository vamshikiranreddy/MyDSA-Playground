package Trees_7;

public class Serilize_Deserilize {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		// Serialize
		String data = serialize(root);
		System.out.println("Serialized: " + data);

		// Deserialize
		TreeNode newRoot = deserialize(data);

		// Serialize again to verify
		System.out.println("After Deserialize: " + serialize(newRoot));
	}

	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}

	public static void helper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null,");
			return;
		}
		sb.append(root.val).append(",");
		helper(root.left, sb);
		helper(root.right, sb);
	}

	public static TreeNode deserialize(String data) {
		String[] arr = data.split(",");
		TreeNode root = Create(arr);
		return root;
	}

	public static int idx = -1;

	public static TreeNode Create(String[] arr) {
		idx++;
		if (idx >= arr.length || arr[idx].equals("null")) {
			return null;
		}
		TreeNode newNode = new TreeNode(Integer.valueOf(arr[idx]));
		newNode.left = Create(arr);
		newNode.right = Create(arr);
		return newNode;
	}
}
