package twoD_matrix;

import java.util.Scanner;

public class Set_0 {
	public static void main(String[]args) {
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
			Set(matrix);
	}

	private static void Set(int[][] matrix) {
		int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        result[k][j] = 0;
                    }
                    for (int l = 0; l < n; l++) {
                        result[i][l] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println( matrix[i][j]);
			}
			System.out.println(" next row --");
		}
		
	}
}
