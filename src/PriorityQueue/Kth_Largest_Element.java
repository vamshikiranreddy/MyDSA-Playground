package PriorityQueue;
import java.util.*;
public class Kth_Largest_Element {
	private static int kth_large(int[] array, int k) {
		PriorityQueue <Integer> minHeap = new PriorityQueue<>();
		for(int i =0;i<k;i++) {
			minHeap.offer(array[i]);
		}
		for(int i =k;i<array.length;i++) {
			if(array[i]>minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(array[i]);
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = in.nextInt();
		}
		System.out.println("Enter The k : ");
		int k = in.nextInt();
		int result = kth_large(array,k);
		System.out.println("The "+k+"th largest number is " + result);
		in.close();
	}

	

}
