package NUMBERs;

import java.util.*;

public class Prime_Numbers {
	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Start range : ");
		int start = in.nextInt();
		System.out.println("Enter The End Range : ");
		int end = in.nextInt();
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				prime.add(i);
			}
		}
		for (int num : prime) {
			System.out.print(num + " ");
		}
		in.close();

	}

}
