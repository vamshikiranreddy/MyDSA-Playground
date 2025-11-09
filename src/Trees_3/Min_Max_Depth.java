package Trees_3;

import java.util.*;

public class Min_Max_Depth {
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

    public static TreeNode create(int[] arr) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }

        TreeNode newNode = new TreeNode(arr[idx]);
        newNode.left = create(arr);
        newNode.right = create(arr);
        return newNode;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = in.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements (-1 for null):");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        idx = -1;
        TreeNode root = create(arr);

        System.out.println("Maximum Depth: " + maxDepth(root));
        System.out.println("Minimum Depth: " + minDepth(root));

        in.close();
    }
}
