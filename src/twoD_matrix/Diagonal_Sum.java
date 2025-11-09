package twoD_matrix;
import java.util.*;
public class Diagonal_Sum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n size :");
		int n = in.nextInt();
		System.out.println("Enter m size :");
		int m = in.nextInt();
		int [][] matrix = new int[n][m];
		System.out.println("Enter matrix elements :");
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				matrix [i][j] = in.nextInt(); 
			}
		}
		int sum = Diagonal_Sum(matrix);
		System.out.println("The Sum " + sum);
		in.close();

	}

	private static int Diagonal_Sum(int[][] matrix) {
		int n = matrix.length;
		int sum = 0;
		for(int i = 0;i<n;i++) {
			sum += matrix[i][i]; // for left diagonal
			sum += matrix[i][n-1-i]; //for right diagonal
		}
		if(n % 2 != 0) {
			sum -= matrix[n/2][n/2];
		}
		return sum;
	}

}
