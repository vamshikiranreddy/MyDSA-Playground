package Binary_Search;

import java.util.Scanner;

public class Lower_Bound {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = in.nextInt();
		}
		System.out.println("Enter The Target : ");
		int target = in.nextInt();
		int index = Binary_Search(array, target);
		System.out.println("The Lower Bound Of  " + target + " is  at Index : " + index);
		in.close();
	}

	private static int Binary_Search(int[] array, int target) {
		int n = array.length;
		int low = 0;
		int high = n-1;
		int ans = n;
		while(low <= high) {
			int middle = low + (high-low)/2;
			if(array[middle] >= target) {
				ans = middle; // if there is any on the left of the middle
				high = middle - 1;
			}else {
				low = middle + 1;
			}
		}
		return ans;
	}

}
