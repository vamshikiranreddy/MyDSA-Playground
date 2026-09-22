package Bit_Manipulation_2;

import java.util.*;

public class Remove_Last_Set_Bit {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");

		int n = sc.nextInt();

		removeLastSetBit(n);

	}

	public static void removeLastSetBit(int n) {

		int result = n & (n - 1);

		System.out.println("After removing last set bit: " + result);

	}

}