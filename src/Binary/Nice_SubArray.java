package Binary;

import java.util.*;

public class Nice_SubArray {
	private static int BitwiseAnd(int[] arr) {
		int j = 0; // pointer
		int length = 0; // length of the subarray
		int num = 0; // for storing the ans for final and
		for (int i = 0; i < arr.length; i++) {
			while ((num & arr[i]) != 0) {
				num ^= arr[j++];
			}
			num |= arr[i];
			length = Math.max(length, i - j + 1);
		}
		return length;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array : ");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		int result = BitwiseAnd(arr);
		System.out.println("The Maximum length is : " + result);
		in.close();

	}

	
}
