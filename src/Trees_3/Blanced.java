package Trees_3;

import java.util.*;

public class Blanced {
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

    public static TreeNode create(int arr[]) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(arr[idx]);
        newNode.left = create(arr);
        newNode.right = create(arr);
        return newNode;
    }

    public static void print(TreeNode root) {
        if (root == null) {
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

        if (isBalanced(root)) {
            System.out.println("The binary tree is balanced.");
        } else {
            System.out.println("The binary tree is not balanced.");
        }

        in.close();
    }

    public static boolean isBalanced(TreeNode root) {
        boolean[] flag = new boolean[1];
        Arrays.fill(flag, true);
        height(root, flag);
        return flag[0];
    }

    public static int height(TreeNode root, boolean[] flag) {
        if (root == null) return 0;

        int leftHeight = height(root.left, flag);
        int rightHeight = height(root.right, flag);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag[0] = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
