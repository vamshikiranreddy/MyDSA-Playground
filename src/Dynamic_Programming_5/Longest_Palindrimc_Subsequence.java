package Dynamic_Programming_5;

public class Longest_Palindrimc_Subsequence {
    public static int lpsTab(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static int lpsSpaceOpt(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }
        return prev[n];
    }

    public static void main(String[] args) {
        String s = "bbbab";

        System.out.println("LPS (Tabulation): " + lpsTab(s));
        System.out.println("LPS (Space Optimized): " + lpsSpaceOpt(s));
    }
}
