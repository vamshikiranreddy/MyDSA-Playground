package Bit_Manipulation;

import java.util.*;

public class Set_ith_Bit {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number: ");

		int n = sc.nextInt();

		System.out.print("Enter i: ");

		int i = sc.nextInt();

		setIthBit(n, i);

	}

	public static void setIthBit(int n, int i) {

		int result = n | (1 << i);

		System.out.println("Number after setting i-th bit: " + result);

	}

}