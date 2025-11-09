package Binary_Search_2;

import java.util.Scanner;

public class Search_Rotated {

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
		int index = Binary_Search(array,target);
		System.out.println("The Element "+ target + " at Index : " + index);
		in.close();
	}

	private static int Binary_Search(int[] array, int target) {
		int n = array.length;
		int low = 0;
		int high = n - 1;
		while(low <= high) {
			int middle = low + (high - low)/2;
			if(array[middle] == target) return middle;
			if(array[low] <= array[middle]) {
				//Check if Left Half Is Sorted
				if(array[low] <= target && array[middle] >= target) {
					high = middle - 1;
				}else {
					low = middle + 1;
				}
			}else {
				//Check if Right Half Is Sorted
				if(array[high] >= target && array[middle] < target) {
					low = middle+1;
				}else {
					high = middle - 1;
				}
			}
		}
		return -1;
	}
}
