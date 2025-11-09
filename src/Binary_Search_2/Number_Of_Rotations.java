package Binary_Search_2;

import java.util.Scanner;

public class Number_Of_Rotations {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int [] array = new int[size];
		for(int i =0;i<size;i++) {
			array [i] = in.nextInt();
		}
		int minimum_idx = Binary_Search(array);
		System.out.println("the number Of Times The Array Is Rotated is  "+ minimum_idx);
		in.close();
	}

	private static int Binary_Search(int[] array) {
		int n = array.length;
		int low = 0;
		int high = n - 1;
		int min = Integer.MAX_VALUE;
		int idx = -1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(array[low] <= array[mid]) {
				if(array[low] < min) {
					min = array[low];
					idx = low;
				}
				low = mid + 1;
			}else {
				if(array[mid] < min) {
					min = array[mid];
					idx = mid;
				}
				high = mid - 1;
			}
		}
		return idx;
	}
}
