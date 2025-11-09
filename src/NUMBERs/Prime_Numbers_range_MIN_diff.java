package NUMBERs;

import java.util.*;

public class Prime_Numbers_range_MIN_diff {
	private static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int []  Close_Pair(int start, int end) {
		ArrayList<Integer> prime_num = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				prime_num.add(i);
			}
		}
		int minDiff = Integer.MAX_VALUE;
        int[] result = new int[]{-1,-1};
        for(int i =1;i<prime_num.size();i++){
            int diff = prime_num.get(i) - prime_num.get(i-1);
            if(diff < minDiff ){
                minDiff = diff;
                result[0] = prime_num.get(i-1);
                result[1] = prime_num.get(i);
            }
        }
        return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Start range : ");
		int start = in.nextInt();
		System.out.println("Enter The End Range : ");
		int end = in.nextInt();
		int []  result = Close_Pair(start, end);
		for (int num : result) {
			System.out.print(num+" ");
		}
	}

}
