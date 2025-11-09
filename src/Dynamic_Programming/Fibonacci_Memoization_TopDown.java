package Dynamic_Programming;

import java.util.*;

public class Fibonacci_Memoization_TopDown {
	static int[] Dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The number of series you need :- ");
		int size = in.nextInt();
		Dp = new int[size + 1];
		Arrays.fill(Dp, -1);
		Dp[0] = 0;
		Dp[1] = 1;
		fibonacci(size);
		System.out.print("The Fibonacci Series Are : - ");
		for (int i = 0; i <= size; i++) {
			System.out.print(Dp[i] + " ");
		}
		System.out.println();
		System.out.println("Enter The number'th fibo number you need :- ");
		int x = in.nextInt();
		System.out.println("The " + x + "th fibonacci number is : " + Dp[x]);
		in.close();
	}

	private static int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (Dp[n] != -1)
			return Dp[n];

		return Dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}

}

