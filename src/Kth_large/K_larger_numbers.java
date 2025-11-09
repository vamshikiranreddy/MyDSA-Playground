package Kth_large;

import java.util.*;

public class K_larger_numbers {
	private static ArrayList<Integer> k_large(int[] array, int k) {
		int n = array.length;
		int i = 1;
		Arrays.sort(array);
		ArrayList<Integer> result = new ArrayList<>();
		while (k > 0) {
			result.add(array[n - i]);
			k--;
			i++;
		}
		return result;
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
		ArrayList<Integer> result = k_large(array, k);
		for (int num : result) {
			System.out.print(num+" ");
		}
		in.close();

	}

}
