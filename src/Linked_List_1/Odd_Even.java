package Linked_List_1;
import java.util.*;
class Node_4{
	int data;
	Node_4 next;
	Node_4(int data){
		this.data = data;
		this.next = null;
	}
}
public class Odd_Even {
	public static Scanner in = new Scanner(System.in);
	private static Node_4 Create() {
		Node_4 head = null;
		Node_4 temp = null;
		boolean Continue = true;
		while(Continue){
			System.out.println("Node_Created !!!!!!!!");
			System.out.println("Enter The Data");
			int data = in.nextInt();
			Node_4 newNode = new Node_4(data);
			if(head == null) {
				head = newNode;
				temp = newNode;
			}else {
				temp.next = newNode;
				temp = newNode;
			}
			System.out.println("Need More?? 1.Yes 2.No");
			int choice = in.nextInt();
			in.nextLine();
			if(choice == 1) {
				Continue = true;
			}else{
				Continue = false;
			}
		}
		return head;
	}
	private static void print(Node_4 head) {
		Node_4 temp = head;
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("Null");
	}
	private static Node_4 odd_even(Node_4 head) {
		if(head == null) {
			return head;
		}
		Node_4 odd = head;
		Node_4 even = head.next;
		Node_4 evenHead = even;
		while(even != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			
			even.next = even.next.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
	public static void main(String[] args) {
		Node_4 head = Create();
		System.out.println("The Original LinkedList : ");
		print(head);
		
		head = odd_even(head);
		System.out.println("The Segregated LinkedList : ");
		print(head);
}
		
}
