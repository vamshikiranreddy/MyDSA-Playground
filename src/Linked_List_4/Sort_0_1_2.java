package Linked_List_4;

import java.util.Scanner;

public class Sort_0_1_2 {
    static class ListNode {
        int data;
        ListNode next;

        ListNode() {}
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Scanner in = new Scanner(System.in);

    private static ListNode Create_Linked_List() {
        ListNode head = null;
        ListNode temp = null;
        boolean Continue = true;
        while (Continue) {
            ListNode newNode = new ListNode();
            System.out.println("Node Created !!!!!!!");
            System.out.println("Enter The Data : ");
            newNode.data = in.nextInt();
            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
            System.out.println("More Nodes ? 1.Yes 2.No");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1)
                Continue = true;
            else
                Continue = false;
        }
        return head;
    }

    private static void Print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        ListNode head = Create_Linked_List();
        System.out.println("Original Linked List ");
        Print(head);

        // ✅ Option 1: Relinking approach
        // head = SortByRearranging(head);

        // ✅ Option 2: Count sort approach
        head = SortByCounting(head);

        System.out.println("Sorted Linked List");
        Print(head);
        in.close();
    }

    // ---------------- Relinking approach ----------------
    private static ListNode SortByRearranging(ListNode head) {
        ListNode ZeroHead = new ListNode(-1);
        ListNode OneHead = new ListNode(-1);
        ListNode TwoHead = new ListNode(-1);

        ListNode zero = ZeroHead, one = OneHead, two = TwoHead;
        ListNode temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (OneHead.next != null) ? OneHead.next : TwoHead.next;
        one.next = TwoHead.next;
        two.next = null;

        return ZeroHead.next;
    }

    // ---------------- Count sort approach ----------------
    private static ListNode SortByCounting(ListNode head) {
        if (head == null) return null;

        int count0 = 0, count1 = 0, count2 = 0;
        ListNode temp = head;

        // Count 0s, 1s, 2s
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        // Rewrite node data
        temp = head;
        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        while (count2-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }
}
