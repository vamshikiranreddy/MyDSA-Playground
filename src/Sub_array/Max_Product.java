package Sub_array;

import java.util.*;

public class Max_Product {
	
	public static int Max_product(int[] arr) {
		int leftproduct = 0,rightproduct = 0,ans = arr[0];
		int n = arr.length;
		for(int i = 0;i<n;i++) {
			leftproduct = leftproduct == 0 ? 1 : leftproduct;
			rightproduct = rightproduct == 0 ? 1 : rightproduct;
			leftproduct *= arr[i];
			rightproduct *= arr[n-1-i];
			ans = Math.max(ans, Math.max(leftproduct, rightproduct));
		}
		return ans;
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The The Array Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		int max_product = Max_product(arr);
		System.out.println("The Max Product : " + max_product);
		in.close();
	}
}
