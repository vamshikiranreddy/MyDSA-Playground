package twoD_matrix_2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Read matrix size
        System.out.println("Enter the number of rows (m): ");
        int m = in.nextInt();
        System.out.println("Enter the number of columns (n): ");
        int n = in.nextInt();
        
        int[][] matrix = new int[m][n];

        // Read matrix elements
        System.out.println("Enter the elements: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        // Sort matrix
        sort(matrix, m, n);

        // Close Scanner
        in.close();
    }

    private static void sort(int[][] matrix, int m, int n) {
        // Min Heap to store elements in sorted order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all elements into the minHeap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minHeap.add(matrix[i][j]);
            }
        }

        // Extract elements from the heap and put them back into the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = minHeap.poll();
            }
        }

        // Print the sorted matrix
        System.out.println("Sorted Matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
