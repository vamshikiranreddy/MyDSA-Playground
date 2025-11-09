
package Trees_5;

import java.util.*;

public class Connect_Next_Pointers {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static int idx;

    // Create binary tree using -1 as null indicator
    public static Node create(int[] arr) {
        idx++;
        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = create(arr);
        newNode.right = create(arr);
        return newNode;
    }

    // Print tree in level order along with next pointers
    public static void printWithNext(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                System.out.print(curr.val + "(" + (curr.next != null ? curr.next.val : "null") + ") ");
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            System.out.println();
        }
    }

    // Connect next pointers
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Size: ");
        int size = in.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter The Elements (-1 for no child): ");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        idx = -1;
        Node root = create(arr);
        connect(root);
        System.out.println("Tree with next pointers (level-order): ");
        printWithNext(root);
        in.close();
    }
}
