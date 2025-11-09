package twoD_matrix;
import java.util.*;
public class Rotate_Matrix {
	public static int[][] Rotate(int[][]matrix){
		int N = matrix.length;
		// transpose
		for(int i = 0;i<N;i++) {
			for(int j = i;j<N;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// reversing each row
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N/2;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][N-1-j];
				matrix[i][N-1-j] = temp;  
			}
		}
		return matrix;
	}
	public static void main(String [] args) {
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
		int result_matrix [][] = Rotate(matrix);
		for(int i = 0;i<size_m;i++) {
			for(int j = 0;j<size_m;j++) {
				System.out.print("|| "+result_matrix[i][j]+" ||");
			}
			System.out.println();
		}
	}
}
