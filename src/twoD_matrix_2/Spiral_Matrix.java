package twoD_matrix_2;
import java.util.*;
import java.util.Scanner;

public class Spiral_Matrix {
	public static List<Integer> Spiral (int [][] matrix){
		List<Integer> result = new ArrayList<>();
		int row_begin = 0;
		int row_end = matrix.length-1;
		int column_begin = 0;
		int column_end = matrix[0].length-1;
		
		while(row_begin<=row_end && column_begin<=column_end) {
			// traverse to right
			for(int j = column_begin;j<=column_end;j++) {
				result.add(matrix[row_begin][j]);
			}
			row_begin++;
			
			//traverse bottom
			for(int j = row_begin;j<=row_end;j++) {
				result.add(matrix[j][column_end]);
			}
			column_end--;
			
			//traverse to left 
			if(row_begin<=row_end) {
				for(int j = column_end;j>=column_begin;j--) {
					result.add(matrix[row_end][j]);
				}
				row_end--;
			}
			
			//traverse top
			if(column_begin<=column_end) {
				for(int j = row_end;j>=row_begin;j--){
					result.add(matrix[j][column_begin]);
				}
				column_begin++;
			}
		}
		
		return result;
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
		List<Integer> result = Spiral(matrix);
		for(int i : result) {
			System.out.print("|"+i+"|");
		}
		in.close();
	}
}
