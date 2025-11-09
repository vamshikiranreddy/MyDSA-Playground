package Arrays;

import java.util.*;

public class Rotate_Array {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter The Size Of Array");
		int size_1 = in.nextInt();

		System.out.println("Enter The Elements");
		int[] array_1 = new int[size_1];
		for (int i = 0; i < size_1; i++) {
			array_1[i] = in.nextInt();
		}

		System.out.println("Enter The Size Of Array 2");
		int size_2 = in.nextInt();

		System.out.println("Enter The Elements");
		int[] array_2 = new int[size_2];
		for (int i = 0; i < size_2; i++) {
			array_2[i] = in.nextInt();
		}

		System.out.println("Enter The Target : ");
		int target = in.nextInt();
		System.out.println("Rotated Array to the Right");
		RotateRight(array_1, target);
		System.out.println(Arrays.toString(array_1));
		System.out.println("Rotated Array to the Left");
		RotateLeft(array_2, target);
		System.out.println(Arrays.toString(array_2));
	}

	// Left rotation = first element goes to the back.
	// Right rotation = last element comes to the front.
	// [1, 2, 3, 4, 5, 6, 7] -> [5, 6, 7, 1, 2, 3, 4]
	private static int[] RotateRight(int[] array, int k) {
		int n = array.length;
		k = k % n;
		Reverse(array, 0, n - 1);
		Reverse(array, 0, k - 1);
		Reverse(array, k, n - 1);
		return array;
	}
	// [1, 2, 3, 4, 5, 6, 7] -> [4, 5, 6, 7, 1, 2, 3]
	private static int[] RotateLeft(int[] array, int k) {
		int n = array.length;
		k = k % n; // for larger than size
		Reverse(array, 0, k - 1);
		Reverse(array, k, n - 1);
		Reverse(array, 0, n - 1);
		return array;
	}

	private static void Reverse(int[] array, int left, int right) {
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}

	}

}
