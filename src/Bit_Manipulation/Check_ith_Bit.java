package Bit_Manipulation;

import java.util.*;

public class Check_ith_Bit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");
		int n = sc.nextInt();

		System.out.print("Enter i: ");
		int i = sc.nextInt();

		checkIthBit(n, i);
	}

	public static void checkIthBit(int n, int i) {

		if ((n & (1 << i)) != 0) {
			System.out.println("i-th bit is SET");
		} else {
			System.out.println("i-th bit is NOT SET");
		}
	}
}