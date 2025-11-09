package twoD_matrix;
import java.util.*;
public class Set_Zero_2 {
    public static void updateFactoryFloor(int[][] matrix, int r, int c) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        
        // Identify rows and columns that need to be zeroed out
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        
        // Update the matrix based on identified rows and columns
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Print the modified matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] matrix = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        updateFactoryFloor(matrix, r, c);
        scanner.close();
    }
}
