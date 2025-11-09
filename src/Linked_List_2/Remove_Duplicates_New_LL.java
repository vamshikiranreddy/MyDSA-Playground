	package Linked_List_2;
	
	import java.util.*;
	
	import Linked_List_2.remove_Duplicates.ListNode;
	
	public class Remove_Duplicates_New_LL {
		static class ListNode {
			int data;
			ListNode next;
			ListNode prev;
			ListNode(){
				this.next = null;
				this.prev = null;
			}
			ListNode(int data) {
				this.data = data;
				this.next = null;
				this.prev = null;
			}
		}
	
		static Scanner in = new Scanner(System.in);
	
		public static ListNode Create() {	
			ListNode head = null;
			ListNode temp = null;
			boolean Continue = true;
			while (Continue) {
				System.out.println("Node Created !!!!!!!!!!!!!!");
				System.out.println("Enter The Data");
				int data = in.nextInt();
				ListNode newNode = new ListNode(data);
				if (head == null) {
					head = newNode;
					temp = newNode;
				} else {
					temp.next = newNode;
					newNode.prev = temp;
					temp = newNode;
				}
				System.out.println("Do You Need More ? 1. Yes 2. No");
				int choice = in.nextInt();
				if (choice == 1) {
					Continue = true;
				} else {
					Continue = false;
				}
			}
			return head;
		}
	
		public static void Print(ListNode head) {
			ListNode temp = head;
			while (temp != null) {
				System.out.print(temp.data + "<->");
				temp = temp.next;
			}
			System.out.print("Null----");
			System.out.println();
		}
		
		public static void main(String[] args) {
			ListNode head = Create();
			System.out.println("The Tree");
			Print(head);
			ListNode Duplicate_head = Remove_Duplicates(head);
			System.out.println("The Tree Afer Removing Duplicates");
			Print(Duplicate_head);
		}
	
		private static ListNode Remove_Duplicates(ListNode head) {
			if(head == null) {
				return null;
			}
			Set<Integer> set = new HashSet<>();
			ListNode newHead = null;
			ListNode newTail = null;
			ListNode current = head;
			while(current != null) {
				if(!set.contains(current.data)) {
					set.add(current.data);
					ListNode newNode  = new ListNode(current.data);
					if(newHead == null) {
						newHead = newNode;
						newTail = newNode;
					}else {
						newTail.next = newNode;
						newNode.prev = newTail;
						newTail = newNode;
					}
					
				}
				current = current.next;
			}
			return newHead;
		}
	}
