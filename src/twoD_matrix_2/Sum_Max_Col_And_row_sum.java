package twoD_matrix_2;

import java.util.*;

class Sum_Max_Col_And_row_sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The row size for m*n : ");
		int R = in.nextInt();
		System.out.println("Enter The Column size for m*n :");
		int C = in.nextInt();
		int[][] matrix = new int[R][C];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				matrix[i][j] = in.nextInt();
			}
			System.out.println(" next row --");
		}
		int max_row = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			int sum = 0;
			for (int j = 0; j < C; j++) {
				sum += matrix[i][j];
			}
			if (sum > max_row) {
				max_row = sum;
			}
		}
		int max_col = Integer.MIN_VALUE;
		for (int j = 0; j < C; j++) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += matrix[i][j];
			}
			if (sum > max_col) {
				max_col = sum;
			}
		}
		int result = max_row + max_col;
		System.out.println(result);
		in.close();
	}
}
