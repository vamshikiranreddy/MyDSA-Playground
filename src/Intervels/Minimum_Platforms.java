package Intervels;

import java.util.*;

public class Minimum_Platforms {
	public static void main(String[] args) {
		int[] arr = { 1000, 935, 1100 };
		int[] dep = { 1200, 1240, 1130 };
		System.out.println(minPlatform(arr, dep));
	}

	private static int minPlatform(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1,j = 0; // starts with one train
		int platforms_needed = 1;
		int count = 1;
		while(i < arr.length && j < dep.length) {
			if(arr[i] <= dep[j]) {
				count++;
				i++;
			}else {
				count--;
				j++;
			}
			platforms_needed = Math.max(platforms_needed, count);
		}
		return platforms_needed;
	}
}
