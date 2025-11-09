package Sub_array;

import java.util.*;

public class Max_Sum_UnqSubarray {
	
	static List<Integer> list ;
	
	public static long Max_Sum(int [] nums,int k) {
		Set <Integer> set = new LinkedHashSet<>();
		long max = 0;
		long sum = 0;
		int start = 0;
		int end = 0;
		while(end < nums.length) {
			if(!set.contains(nums[end])) {
				set.add(nums[end]);
				sum += nums[end];
				end++;
				if(set.size() == k) {
					if(sum>max) {
						max = sum;
						list = new ArrayList<>(set);
					}
					sum -= nums[start];
					set.remove(nums[start]);
					start++;
				}
			}else {
				set.remove(nums[start]);
				sum -= nums[start];
				start++;
			}
		}
		return max;
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
		System.out.println("The Array : ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("Enter The Size Of k (subarray size) ");
		int k = in.nextInt();
		long max_sum = Max_Sum(arr,k);
		System.out.println("The Max Sum : " + max_sum + "\n The List " + list);
		in.close();

	}

}
