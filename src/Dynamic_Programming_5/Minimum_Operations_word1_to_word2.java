package Dynamic_Programming_5;

public class Minimum_Operations_word1_to_word2 {

    public static void main(String[] args) {
        String w1 = "sea";
        String w2 = "eat";

        int tab = editDistanceTabulation(w1, w2);
        int opt = editDistanceSpaceOptimized(w1, w2);

        System.out.println("Minimum Operations (Tabulation) = " + tab);
        System.out.println("Minimum Operations (Space Optimized) = " + opt);
    }

    private static int editDistanceTabulation(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];
        int deletions = (m - lcs) + (n - lcs);
        return deletions;
    }

    private static int editDistanceSpaceOptimized(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            System.arraycopy(curr, 0, prev, 0, n + 1);
        }

        int lcs = prev[n];
        int deletions = (m - lcs) + (n - lcs);
        return deletions;
    }
}
