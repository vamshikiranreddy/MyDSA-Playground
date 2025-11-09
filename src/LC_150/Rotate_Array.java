package LC_150;
import java.util.*;
public class Rotate_Array {
	private static void Rotate(int[] arr,int k) {
		int n = arr.length;
		// for K<N
		 k = k % n;
		 reverse(arr,0,n-1);
		 reverse(arr,0,k-1);
		 reverse(arr,k,n-1);
		 
		 System.out.println("The Rotated Array is : ");
		 for(int i =0;i<arr.length;i++) {
			 System.out.print(arr[i]+" ");
		 }
		
	}
	public static void reverse(int [] arr,int left,int right) {
		while(left<right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array : ");
		int size = in.nextInt();
		System.out.println("Enter The K = ");
		int k = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The The Array Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		Rotate(arr,k);
	}

	
}
