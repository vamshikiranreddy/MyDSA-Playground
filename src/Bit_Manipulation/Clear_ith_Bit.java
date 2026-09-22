package Bit_Manipulation;

import java.util.*;

public class Clear_ith_Bit {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");

		int n = sc.nextInt();

		System.out.print("Enter i: ");

		int i = sc.nextInt();

		clearIthBit(n, i);

	}

	public static void clearIthBit(int n, int i) {

		int result = n & ~(1 << i);

		System.out.println("Number after clearing i-th bit: " + result);

	}

}