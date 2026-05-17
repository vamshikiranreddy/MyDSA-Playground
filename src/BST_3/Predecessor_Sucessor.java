package BST_3;

import java.util.*;

public class Predecessor_Sucessor {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert into BST
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    // 🔥 Find Predecessor & Successor
    public static ArrayList<Node> findPreSuc(Node root, int key) {

        Node predecessor = null;
        Node successor = null;

        ArrayList<Node> result = new ArrayList<>();

        // 🔹 Predecessor (max < key)
        Node curr = root;
        while (curr != null) {
            if (curr.data < key) {
                predecessor = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // 🔹 Successor (min > key)
        curr = root;
        while (curr != null) {
            if (curr.data > key) {
                successor = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        result.add(predecessor);
        result.add(successor);

        return result;
    }

    // Inorder (just for visualization)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] values = {10, 5, 1, 7, 40, 50};
        Node root = null;

        for (int v : values) {
            root = insert(root, v);
        }

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        int key = 10;

        ArrayList<Node> res = findPreSuc(root, key);

        Node pre = res.get(0);
        Node suc = res.get(1);

        System.out.println("Predecessor of " + key + ": " + (pre != null ? pre.data : -1));
        System.out.println("Successor of " + key + ": " + (suc != null ? suc.data : -1));
    }
}