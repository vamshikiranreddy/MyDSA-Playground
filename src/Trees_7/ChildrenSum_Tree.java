package Trees_7;

import java.util.*;

public class ChildrenSum_Tree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static TreeNode Create(int[] arr) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }

        TreeNode newNode = new TreeNode(arr[idx]);
        newNode.left = Create(arr);
        newNode.right = Create(arr);
        return newNode;
    }

    public static void PrintPreOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        PrintPreOrder(root.left);
        PrintPreOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("The Size : ");
        int size = in.nextInt();

        int[] arr = new int[size];

        System.out.println("The Values Of The Node : ");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        idx = -1;
        TreeNode root = Create(arr);

        System.out.println("The Tree (Pre-Order) :- ");
        PrintPreOrder(root);
        System.out.println();

        if (isChildSumTree(root)) {
            System.out.println("Yes The Tree Follows ChildSum Property !");
        } else {
            System.out.println("No The Tree Doesn't Follow ChildSum Property !");
        }

        in.close();
    }

    private static boolean isChildSumTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return true;

        int left = (root.left != null) ? root.left.data : 0;
        int right = (root.right != null) ? root.right.data : 0;

        if (root.data == left + right && isChildSumTree(root.left) && isChildSumTree(root.right)) {
            return true;
        }

        return false;
    }
}
