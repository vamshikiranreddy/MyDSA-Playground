package BST_2;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
public class SortedList_ToBST {
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// Main function
	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return buildBST(head, null);
	}

	// Recursive function to build BST
	private static TreeNode buildBST(ListNode head, ListNode tail) {
		if (head == tail)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		// find middle node
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = buildBST(head, slow); // left half
		root.right = buildBST(slow.next, tail); // right half
		return root;
	}

	// Helper: inorder traversal (to check result)
	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		// Example: Linked list [-10, -3, 0, 5, 9]
		ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));

		TreeNode root = sortedListToBST(head);

		System.out.println("Inorder Traversal of BST:");
		inorder(root); // should print: -10 -3 0 5 9
	}
}
