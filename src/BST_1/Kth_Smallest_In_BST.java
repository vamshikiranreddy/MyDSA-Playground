
package BST_1;
import java.util.*;

public class Kth_Smallest_In_BST {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    // BST Insertion (fixed logic)
    public static TreeNode Insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.data) {
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }
        return root;
    }

    // Inorder Traversal
    public static void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    // Kth Smallest Element (Iterative Inorder)
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k == 0) return current.data;
            current = current.right;
        }
        return -1; // Invalid k
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Size:");
        int size = in.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter The Elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = in.nextInt();
        }

        TreeNode root = null;
        for (int num : nums) {
            root = Insert(root, num);
        }

        System.out.println("The BST [Inorder]:");
        print(root);
        System.out.println();

        System.out.println("Enter k to find the kth Smallest Element:");
        int k = in.nextInt();
        int kth = kthSmallest(root, k);
        if (kth == -1) {
            System.out.println("Invalid k value");
        } else {
            System.out.println("The " + k + "th smallest element is: " + kth);
        }

        in.close();
    }
}
