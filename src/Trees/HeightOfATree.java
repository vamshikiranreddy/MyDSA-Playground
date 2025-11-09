package Trees;

import java.util.*;

class NODE {
    int data;
    NODE left;
    NODE right;

    NODE(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class HeightOfATree {
    static int idx = -1;

    public static NODE createTree(int[] array) {
        idx++;
        if (idx >= array.length || array[idx] == -1) {
            return null;
        }
        NODE newNode = new NODE(array[idx]);
        newNode.left = createTree(array);
        newNode.right = createTree(array);
        return newNode;
    }

    public static void printTree(NODE root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static int maxDepth(NODE root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Size: ");
        int size = in.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements (-1 for no children):");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        idx = -1; // Reset idx before creating the tree
        NODE root = createTree(array);
        System.out.println("The Tree: ");
        printTree(root);
        int maxDepth = maxDepth(root);
        System.out.println("\nThe Maximum depth is: " + maxDepth);
        in.close();
    }
}