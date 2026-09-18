package Bit_Manipulation;

import java.util.*;

public class Binary_To_Decimal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a binary number: ");
		String n = sc.nextLine();

		// Method 1: Manual conversion
		int result1 = binaryToDecimal(n);
		System.out.println("Manual Method: " + result1);

		// Method 2: Built-in Java method
		int result2 = binaryToDecimalBuiltIn(n);
		System.out.println("Built-in Method: " + result2);

		sc.close();
	}

	// Method 1: Using place values
	private static int binaryToDecimal(String n) {

		int len = n.length();
		int pow = 0;
		int num = 0;

		for (int i = len - 1; i >= 0; i--) {

			if (n.charAt(i) == '1') {
				num = num + (int) Math.pow(2, pow);
			}
			pow++;
		}

		return num;
	}

	// Method 2: Using Java's built-in function
	private static int binaryToDecimalBuiltIn(String num) {

		return Integer.parseInt(num, 2);
	}
}