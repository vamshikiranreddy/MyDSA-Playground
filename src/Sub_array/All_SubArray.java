package Sub_array;

import java.util.Scanner;

public class All_SubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The The Array Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("All Possible SubArrays are ");
		int N = arr.length;
		for(int start =0;start<N;start++){
			for(int end = start;end<=N;end++) {
				System.out.print("[");
				for(int k = start;k<end;k++) {
					System.out.print(arr[k]);
				}
				System.out.print("]");
				System.out.println();
			}
			
		}

	}

}
