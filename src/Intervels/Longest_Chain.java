package Intervels;

import java.util.*;

public class Longest_Chain {

	public static void main(String[] args) {
		int[][] pairs = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		System.out.println(findLongestChain(pairs)); 

	}

	private static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		int count = 1;
		int end = pairs[0][1];
		for (int i = 1; i < pairs.length; i++) {
			if (end < pairs[i][0]) {
				count++;
				end = pairs[i][1];
			}
		}
		return count;
	}

}
