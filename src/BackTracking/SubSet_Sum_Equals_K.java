package BackTracking;

import java.util.*;

public class SubSet_Sum_Equals_K {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		int K = 3;
		List<List<Integer>> temp = SubsequenceSum(arr,K);
		System.out.println(temp);
	}

	private static List<List<Integer>> SubsequenceSum(int[] arr, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currList = new ArrayList<>();
		recursion(0,arr,k,currList,result,0);
		return result;
	}

	private static void recursion(int idx,int[] arr, int k, List<Integer> currList,List<List<Integer>> result, int sum) {
		if(idx == arr.length) {
			if(sum == k) {
				result.add(new ArrayList<>(currList));
			}
			return;
		}
		//include
		sum += arr[idx];
		currList.add(arr[idx]);
		recursion(idx+1,arr,k,currList,result,sum);
		sum -= arr[idx];
		currList.remove(currList.size() - 1);
		
		// not Include
		recursion(idx + 1,arr,k,currList,result,sum);
		
	}

}
