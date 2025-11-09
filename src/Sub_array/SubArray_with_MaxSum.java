package Sub_array;
import java.util.*;
public class SubArray_with_MaxSum {
	public static int Subarray_Max_Sum(int arr[]) {
		int max_sum = Integer.MIN_VALUE;
		int current_sum = 0;
		for(int i = 0;i<arr.length;i++) {
			current_sum += arr[i];
			if(current_sum>max_sum) {
				max_sum = current_sum;
			}
			if(current_sum <0) current_sum = 0 ;
		}
		return max_sum;
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter The Size of The Array_1 : ");
		int size =  in.nextInt();
		System.out.println("Enter The Elements");
		int arr []= new int[size];
		for(int i = 0;i<size;i++) {
			arr[i]= in.nextInt();
		}
		int result = Subarray_Max_Sum(arr);
		System.out.println("The Maximum Subarray sum is " + result);
		in.close();
	}

}
