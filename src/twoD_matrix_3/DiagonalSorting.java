package twoD_matrix_3;

import java.util.*;

public class DiagonalSorting {

	public static void main(String[] args) {
		int[][] Mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };

		System.out.println("The Matrix Before : ");
		int m = Mat.length, n = Mat[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(Mat[i][j] + ",");
			}
			System.out.println();
		}

		SortDiagonally(Mat);

		System.out.println("The Matrix After : ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(Mat[i][j] + ",");
			}
			System.out.println();
		}
	}

	private static void SortDiagonally(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap<>();

		// Store elements of each diagonal
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				diagonalMap.computeIfAbsent(i - j, k -> new PriorityQueue<>()).offer(mat[i][j]);
			}
		}

		// Fill back sorted values
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = diagonalMap.get(i - j).poll();
			}
		}
	}
}