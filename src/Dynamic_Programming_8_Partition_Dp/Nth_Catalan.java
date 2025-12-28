package Dynamic_Programming_8_Partition_Dp;

public class Nth_Catalan {

	public static void main(String[] args) {
		int n = 3;
		int ans = nthCatalan(n);

		System.out.println("Nth Catalan Number : " + ans);
	}

	public static int nthCatalan(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;

		for (int nodes = 2; nodes <= n; nodes++) {
			dp[nodes] = 0;
			for (int pivot = 1; pivot <= nodes; pivot++) {
				int left  = pivot - 1;
				int right = nodes - pivot;
				dp[nodes] += dp[left] * dp[right];
			}
		}
		return dp[n];
	}
}
