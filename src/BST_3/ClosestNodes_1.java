package BST_3;

import java.util.*;

public class ClosestNodes_1 {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<List<Integer>> result = new ArrayList<>();

        for (int x : queries) {
            int floor = findFloor(root, x);
            int ceil = findCeil(root, x);

            List<Integer> temp = new ArrayList<>();
            temp.add(floor);
            temp.add(ceil);

            result.add(temp);
        }

        return result;
    }
    public static int findFloor(TreeNode root, int x) {
        int floor = -1;

        while (root != null) {
            if (root.val == x) {
                return root.val;
            } 
            else if (root.val > x) {
                root = root.left;
            } 
            else {
                floor = root.val;
                root = root.right;
            }
        }

        return floor;
    }

    public static int findCeil(TreeNode root, int x) {
        int ceil = -1;

        while (root != null) {
            if (root.val == x) {
                return root.val;
            } 
            else if (root.val < x) {
                root = root.right;
            } 
            else {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
    public static void main(String[] args) {

        int[] values = {10, 5, 1, 7, 40, 50};
        TreeNode root = null;

        for (int v : values) {
            root = insert(root, v);
        }

        List<Integer> queries = Arrays.asList(0, 6, 10, 55);

        List<List<Integer>> ans = closestNodes(root, queries);

        for (List<Integer> pair : ans) {
            System.out.println(pair);
        }
    }
}