package twoD_matrix_2;

import java.util.Scanner;

public class twoD_matrix_II {
	public static boolean Search_II(int matrix[][], int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int rows = matrix.length;
		int columns = matrix[0].length;

		int row = 0;
		int column = columns - 1;

		while (row < rows && column >= 0) {
			if (matrix[row][column] == target) {
				return true;
			} else if (matrix[row][column] > target) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The row size for m*n : ");
		int size_m = in.nextInt();
		System.out.println("Enter The Column size for m*n :");
		int size_n = in.nextInt();
		int[][] matrix = new int[size_m][size_n];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < size_m; i++) {
			for (int j = 0; j < size_n; j++) {
				matrix[i][j] = in.nextInt();
			}
			System.out.println(" next row --");
		}
		System.out.println("Enter The Element To Be Found : ");
		int target = in.nextInt();
		boolean found = Search_II(matrix, target);
		if (found) {
			System.out.println("The Taget [" + target + "] found!!!");
		} else {
			System.out.println("The Target [" + target + "] not found.....");
		}
		in.close();
	}
}
