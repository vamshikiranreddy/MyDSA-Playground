package Dynamic_Programming_5;

public class Edit_Distance {

	public static void main(String[] args) {
		String w1 = "horse";
		String w2 = "ros";

		int memoAns = editDistanceMemo(w1, w2);
		System.out.println("Edit Distance (Memo): " + memoAns);

		int taboAns = editDistanceTabulation(w1, w2);
		System.out.println("Edit Distance (Tabulation): " + taboAns);

		int optAns = editDistanceSpaceOptimized(w1, w2);
		System.out.println("Edit Distance (Space Optimized): " + optAns);

	}

	public static int editDistanceMemo(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			java.util.Arrays.fill(dp[i], -1);
		}

		return solveMemo(s1, s2, m - 1, n - 1, dp);
	}

	private static int solveMemo(String s1, String s2, int i, int j, int[][] dp) {
		if (i < 0)
			return j + 1;
		if (j < 0)
			return i + 1;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = solveMemo(s1, s2, i - 1, j - 1, dp);
		}

		int insert = solveMemo(s1, s2, i, j - 1, dp);
		int delete = solveMemo(s1, s2, i - 1, j, dp);
		int replace = solveMemo(s1, s2, i - 1, j - 1, dp);

		return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
	}

	public static int editDistanceTabulation(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m + 1][n + 1];

		// base cases
		for (int j = 0; j <= n; j++)
			dp[0][j] = j;
		for (int i = 0; i <= m; i++)
			dp[i][0] = i;

		// fill
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i][j - 1], // insert
							Math.min(dp[i - 1][j], // delete
									dp[i - 1][j - 1] // replace
							));
				}
			}
		}
		return dp[m][n];
	}

	public static int editDistanceSpaceOptimized(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int[] prev = new int[n + 1];
		int[] curr = new int[n + 1];

		// base row
		for (int j = 0; j <= n; j++)
			prev[j] = j;

		for (int i = 1; i <= m; i++) {
			curr[0] = i;

			for (int j = 1; j <= n; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					curr[j] = prev[j - 1];
				} else {
					curr[j] = 1 + Math.min(curr[j - 1], // insert
							Math.min(prev[j], // delete
									prev[j - 1] // replace
							));
				}
			}

			// shift
			prev = curr.clone();
		}

		return prev[n];
	}
}
