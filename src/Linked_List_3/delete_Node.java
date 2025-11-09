package Linked_List_3;

public class delete_Node {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to delete a given node (except tail) from the linked list when only that node is given
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Invalid node or node is the tail");
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Helper method to print linked list from given node
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        delete_Node listOps = new delete_Node();

        // Creating linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println("Original list:");
        listOps.printList(head);

        // Suppose we want to delete node with value 5
        ListNode nodeToDelete = head.next; // node with value 5

        listOps.deleteNode(nodeToDelete);

        System.out.println("List after deleting node with value 5:");
        listOps.printList(head);
    }
}
