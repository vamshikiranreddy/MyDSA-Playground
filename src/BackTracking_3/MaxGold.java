package BackTracking_3;

public class MaxGold {

    public static void main(String[] args) {
        int[][] Mat = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };

        int maxGold = FindMax(Mat);
        System.out.println("The Max Gold To Be Taken is : " + maxGold);
    }

    private static int FindMax(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int maxGold = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    maxGold = Math.max(maxGold, recursiveBackTracking(i, j, mat));
                }
            }
        }
        return maxGold;
    }

    private static int recursiveBackTracking(int i, int j, int[][] mat) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0)
            return 0;

        int gold = mat[i][j];
        mat[i][j] = 0; // mark visited

        int max = 0;

        max = Math.max(max, recursiveBackTracking(i + 1, j, mat));
        max = Math.max(max, recursiveBackTracking(i - 1, j, mat));
        max = Math.max(max, recursiveBackTracking(i, j + 1, mat));
        max = Math.max(max, recursiveBackTracking(i, j - 1, mat));

        mat[i][j] = gold; // backtrack

        return gold + max;
    }
}