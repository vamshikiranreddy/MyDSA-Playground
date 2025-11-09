package Sub_array;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Sum_in_SubArray_ofFour {
	private static int Min_Sum(int[] arr) {
		int n = arr.length;
		if(n<=3) {
			return Arrays.stream(arr).min().getAsInt();
		}
		int dp [] = new int[n];
		dp[0] = arr[0];
		dp[1] = arr[1];
		dp[2] = arr[2];
		dp[3] = arr[3];
		for(int i = 4;i<n;i++) {
			dp [i] = arr[i] + Math.min(Math.min(dp[i-1], dp[i-2]), Math.min(dp[i-3],dp[i-4]));
		}
		
		return Math.min(Math.min(dp[n-1], dp[n-2]), Math.min(dp[n-3],dp[n-4]));
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array_1 : ");
		int size =  in.nextInt();
		System.out.println("Enter The Elements");
		int arr []= new int[size];
		for(int i = 0;i<size;i++) {
			arr[i]= in.nextInt();
		}
		int result = Min_Sum(arr);
		System.out.println("The Minimum Sum Of SubArray Of Size Four is : " + result);
		in.close();
	}


}
