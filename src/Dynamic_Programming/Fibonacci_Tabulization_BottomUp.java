package Dynamic_Programming;

import java.util.Scanner;

public class Fibonacci_Tabulization_BottomUp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The number of series you need :- ");
		int size = in.nextInt();
		int[] Dp = new int[size + 1];
		Dp[0] = 0;
		Dp[1] = 1;
		for (int i = 2; i <= size; i++) {
			Dp[i] = Dp[i - 1] + Dp[i - 2];
		}
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

}
