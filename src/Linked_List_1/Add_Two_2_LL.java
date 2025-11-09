package Linked_List_1;

import java.util.*;

class Node_3 {
	int data;
	Node_3 next;
	Node_3(int data){
		this.data = data;
		this.next = null;
	}
}

public class Add_Two_2_LL {
	public static Scanner in = new Scanner(System.in);

	public static Node_3 Create() {
		Node_3 head = null;
		Node_3 temp = null;
		boolean Continue = true;
		while (Continue) {
			System.out.println("New Node Created!");
			System.out.println("Enter The Data :");
			int data = in.nextInt();
			Node_3 newNode = new Node_3(data);

			if (head == null) {
				head = newNode;
				temp = newNode;
			} else {
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("Need More? 1.Yes 2.No ");
			int choice = in.nextInt();
			if (choice == 1) {
				Continue = true;
			} else {
				Continue = false;
			}
		}
		return head;
	}

	public static void print(Node_3 head) {
		Node_3 temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node_3 Sum(Node_3 l1, Node_3 l2) {
		Node_3 result = new Node_3(0);
		Node_3 pointer = result;
		int sum = 0, carry = 0;
		while (l1 != null || l2 != null) {
			sum = carry;
			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}
			carry = sum / 10;
			sum = sum % 10;
			pointer.next = new Node_3(sum);
			pointer = pointer.next;
		}
		if (carry == 1) {
			pointer.next = new Node_3(carry);
		}
		return result.next;
	}

	public static void main(String[] args) {
		Node_3 List_1 = Create();
		Node_3 List_2 = Create();
		Node_3 result = Sum(List_1, List_2);
		System.out.println("List 1 :");
		print(List_1);
		System.out.println("List 2 :");
		print(List_2);
		System.out.println("The Sum of L1 and L2 is");
		print(result);
		System.out.println();

	}

}
