package Binary_Search_2;

import java.util.Scanner;

public class Search_Rotated_Duplicates {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int [] array = new int[size];
		for(int i =0;i<size;i++) {
			array [i] = in.nextInt();
		}
		System.out.println("Enter The Target : ");
		int target = in.nextInt();
		if(Binary_Search(array,target)) {
			System.out.println("The Element "+ target + " is Present ");
		}else {
			System.out.println("The Element "+ target + "isn't Present " );
		}
		in.close();
	}

	private static boolean Binary_Search(int[] array, int target) {
		int n = array.length;
		int low = 0;
		int high = n - 1;
		while(low <= high) {
			int middle = low + (high - low)/2;
			if(array[middle] == target) return true;
			
			if(array[low] == array[middle] && array[middle] == array[high]) {
				low--;
				high++;
			}else if(array[low] <= array[middle]) {
				if(array[low] <= target && array[middle] >= target) {
					high = middle - 1;
				}else {
					low = middle + 1;
				}
			}else {
				if(array[high] >= target && array[middle] < target) {
					low = middle + 1;
				}else {
					high = middle - 1;
				}
			}
		}
		return true;
	}

}
