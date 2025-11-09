package twoD_matrix_2;

import java.util.*;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] B = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
		System.out.println("Matrix A:");
		printMatrix(A);

		System.out.println("Matrix B:");
		printMatrix(B);

		int[][] result = Multiply(A, B);
		
		System.out.println("Multiplied Matrix");
		printMatrix(result);
	}

	private static int[][] Multiply(int[][] a, int[][] b) {
		int rowsA = a.length;
		int colsA = a[0].length;
		int rowsB = b.length;
		int colsB = b[0].length;
		
		if(colsA != rowsB) {
			System.out.println("Multiplicaiton not possible");
			return new int[0][0];
		}
		int c [][] = new int [rowsA][colsB];
		for(int i = 0;i<rowsA;i++) {
			for(int j = 0;j<colsB;j++) {
				for(int k = 0;k<rowsB;k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
