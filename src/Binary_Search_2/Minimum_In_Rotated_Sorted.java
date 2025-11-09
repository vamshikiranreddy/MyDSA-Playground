package Binary_Search_2;

import java.util.*;

public class Minimum_In_Rotated_Sorted {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int [] array = new int[size];
		for(int i =0;i<size;i++) {
			array [i] = in.nextInt();
		}
		int minimum = Binary_Search(array);
		System.out.println("The Minimum Element Is "+ minimum);
		in.close();
	}

	private static int Binary_Search(int[] array) {
		int n = array.length;
		int low = 0;
		int high = n - 1;
		int min = Integer.MAX_VALUE;
		while(low <= high) {
			int mid  = low + (high - low)/2;
			//if Left Is Sorted
			if (array[low] <= array[mid]) {
				min = Math.min(min, array[low]);
				low = mid + 1;
			}else { // If Right Is Sorted
				min = Math.min(min, mid);
				high = mid - 1; 
			}
		}
		return min;
	}
}
