package Sub_array;

import java.util.*;

public class Subarray_Sum {
	public static int Check(int[] arr, int target) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == target)
					count++;
			}
		}
		return count;
	}
	public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0,count = 0;
        for(int num : nums){
            sum += num;
            if(prefixSum.containsKey(sum - k)){
                count += prefixSum.get(sum-k);
            }
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0) + 1);
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The The Array Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter The Target Sum : ");
		int target = in.nextInt();
		int Result = subarraySum(arr, target);
		System.out.println("The Count Of Subarrays are : " + Result);
		in.close();
	}

}
