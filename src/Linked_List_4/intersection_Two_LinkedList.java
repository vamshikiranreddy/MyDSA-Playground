package Linked_List_4;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class intersection_Two_LinkedList {
    
    // Two-Pointer Approach (Reference Intersection)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Traverse both lists. When a pointer reaches end, switch to the other list's head
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        // Either returns the intersection node or null if no intersection
        return pA;
    }
    
    public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        
        // Creating second linked list: 6 -> 7
        ListNode headB = new ListNode(6);
        headB.next = new ListNode(7);
        
        // Creating intersection: 8 -> 9
        ListNode intersectNode = new ListNode(8);
        intersectNode.next = new ListNode(9);
        
        // Connect lists to intersection
        headA.next.next.next = intersectNode; // 1->2->3->8->9
        headB.next.next = intersectNode;      // 6->7->8->9
        
        // Find intersection
        ListNode result = getIntersectionNode(headA, headB);
        
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection found");
        }
    }
}
