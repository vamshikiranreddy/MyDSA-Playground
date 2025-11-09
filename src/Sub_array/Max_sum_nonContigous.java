package Sub_array;

import java.util.*;

public class Max_sum_nonContigous {
	private static int Max_Sum(int[] arr) {
		int n = arr.length;
		int sum = 0;
		int max_element = arr[0];
		for (int num : arr) {
			if (num > 0) {
				sum += num;
				max_element = Math.max(max_element, sum);
			}
		}
		return sum > 0 ? sum : max_element;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array_1 : ");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		int result = Max_Sum(arr);
		System.out.println("The Maximum Sum Of SubArray Of Size Four is : " + result);
		in.close();

	}

}
