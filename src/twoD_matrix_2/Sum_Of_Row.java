package twoD_matrix_2;
import java.util.*;
public class Sum_Of_Row {
	public static void Sum_row(int [][] matrix,int m ,int n){
		for(int i =0;i<m;i++){
			int sum  = 0;
			for(int j=0;j<n;j++) {
				sum += matrix[i][j];
			}
			System.out.println("The Sum Of Row "+ i+1 + " is" + sum);
		}
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The (m*n) row value");
		int m = in.nextInt();
		System.out.println("Enter The (m*n) column value");
		int n = in.nextInt();
		int [][] matrix = new int[m][n];
		System.out.println("Enter The Values : ");
		for(int i =0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				matrix[i][j] = in.nextInt();
			}
			System.out.println("NextRow --------");
		}
		Sum_row(matrix,m,n);
		in.close();
	}
}
