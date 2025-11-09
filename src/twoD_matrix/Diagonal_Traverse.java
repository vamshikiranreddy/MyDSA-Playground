package twoD_matrix;
import java.util.*;

public class Diagonal_Traverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The number of Rows");
        int m = in.nextInt();
        System.out.println("Enter The number of Columns");
        int n = in.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Enter The Elements");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
            System.out.println("next Row---");
        }

        // Approach 1: Using Map (k = i + j)
        List<Integer> result1 = diagonal_traverse_using_map(matrix);
        System.out.println("Diagonal Traversal using Map (k = i + j):");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Approach 2: Two-pointer method (your original logic)
        List<Integer> result2 = diagonal_traverse(matrix);
        System.out.println("Diagonal Traversal using Two Pointers:");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

        in.close();
    }

    // APPROACH 1: Using k = i + j and HashMap
    public static List<Integer> diagonal_traverse_using_map(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Group elements by (i+j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(matrix[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        // Iterate through all possible k values
        for (int k = 0; k <= m + n - 2; k++) {
            List<Integer> diagonal = map.get(k);
            if (diagonal == null) continue;

            // Reverse diagonal for even k (zigzag effect)
            if (k % 2 == 0) {
                Collections.reverse(diagonal);
            }
            result.addAll(diagonal);
        }
        return result;
    }

    // APPROACH 2: Your original two-pointer solution
    public static List<Integer> diagonal_traverse(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        if (m == 0 || n == 0) {
            return result;
        }

        int row = 0, column = 0;
        boolean up = true;

        while (result.size() < m * n) {
            result.add(matrix[row][column]);

            if (up) {
                if (column == n - 1) {  // Hit rightmost column → move down
                    row++;
                    up = false;
                } else if (row == 0) {  // Hit top row → move right
                    column++;
                    up = false;
                } else {  // Move up-right
                    row--;
                    column++;
                }
            } else {
                if (row == m - 1) {  // Hit bottom row → move right
                    column++;
                    up = true;
                } else if (column == 0) {  // Hit leftmost column → move down
                    row++;
                    up = true;
                } else {  // Move down-left
                    row++;
                    column--;
                }
            }
        }
        return result;
    }
}
