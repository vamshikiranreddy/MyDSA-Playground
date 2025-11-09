package twoD_matrix;

import java.util.*;

public class Frequent_Missing {
	public static int[] frequent_missing(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int a = 0, b = 0;
		int[] arr = new int[m * n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[matrix[i][j]]++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 1)
				a = i;
			if (arr[i] == 0)
				b = i;
		}

		return new int[] { a, b };
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The m ");
		int m = in.nextInt();
		System.out.println("ENter The Size Of The n ");
		int n = in.nextInt();
		int[][] matrix = new int[m][n];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		int[] result = frequent_missing(matrix);
		System.out.println("The Frequent One is :" + result[0]);
		System.out.println("The Missing One is :" + result[1]);
		in.close();

	}

}
