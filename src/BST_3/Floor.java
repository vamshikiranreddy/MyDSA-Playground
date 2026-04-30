package BST_3;

public class Floor {

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

    // Insert into BST
    public static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }

        if (num < root.data) {
            root.left = insert(root.left, num);
        } else {
            root.right = insert(root.right, num);
        }

        return root;
    }

    // Inorder traversal (just to verify tree)
    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 🔥 Iterative Floor Function
    public static int findFloor(TreeNode root, int x) {
        int floor = -1;

        while (root != null) {
            if (root.data == x) {
                return root.data;
            } 
            else if (root.data > x) {
                root = root.left;
            } 
            else {
                floor = root.data;   // candidate
                root = root.right;
            }
        }

        return floor;
    }

    public static void main(String[] args) {

        int[] values = {10, 5, 1, 7, 40, 50};
        TreeNode root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        int x = 6;
        int floor = findFloor(root, x);

        System.out.println("Floor of " + x + " is: " + floor);
    }
}