package Trees;

import java.util.*;

// Tree Definition
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.data = x;
        this.left = this.right = null;
    }
}

public class BinaryTreeTraversals {
    // Building tree
    static int index = -1;

    public static TreeNode buildTree(int[] array) {
        index++;
        if (index >= array.length || array[index] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(array[index]);
        newNode.left = buildTree(array);
        newNode.right = buildTree(array);
        return newNode;
    }

    public static void print(List<Integer> tree) {
        for (int num : tree) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printLevel(List<List<Integer>> tree) {
        for (List<Integer> list : tree) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Size Of The Array: ");
        int size = in.nextInt();
        int[] array = new int[size];
        System.out.println("Enter The Elements (-1 for no child): ");
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        index = -1;
        TreeNode root = buildTree(array);
        System.out.println("Select Operation: ");
        System.out.println("1. Pre-Order Traversal");
        System.out.println("2. Post-Order Traversal");
        System.out.println("3. In-Order Traversal");
        System.out.println("4. Level-Order Traversal");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                List<Integer> treePre = new ArrayList<>();
                preOrder(root, treePre);
                System.out.println("The Elements of Pre-Order are: ");
                print(treePre);
                break;
            case 2:
                List<Integer> treePost = new ArrayList<>();
                postOrder(root, treePost);
                System.out.println("The Elements of Post-Order are: ");
                print(treePost);
                break;
            case 3:
                List<Integer> treeInOrder = new ArrayList<>();
                inOrder(root, treeInOrder);
                System.out.println("The Elements of In-Order are: ");
                print(treeInOrder);
                break;
            case 4:
                List<List<Integer>> treeLevel = new ArrayList<>();
                levelOrder(root, treeLevel);
                System.out.println("The Elements of Level-Order are: ");
                printLevel(treeLevel);
                break;
            default:
                System.out.println("Invalid Option!");
        }
        in.close();
    }

    // Pre-order {ROOT -> LEFT -> RIGHT}
    public static void preOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        tree.add(root.data);
        preOrder(root.left, tree);
        preOrder(root.right, tree);
    }

    // In-order {LEFT -> ROOT -> RIGHT}
    public static void inOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        inOrder(root.left, tree);
        tree.add(root.data);
        inOrder(root.right, tree);
    }

    // Post-order {LEFT -> RIGHT -> ROOT}
    public static void postOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }
        postOrder(root.left, tree);
        postOrder(root.right, tree);
        tree.add(root.data);
    }

    // Level-order
    public static void levelOrder(TreeNode root, List<List<Integer>> tree) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            tree.add(list);
        }
    }
}