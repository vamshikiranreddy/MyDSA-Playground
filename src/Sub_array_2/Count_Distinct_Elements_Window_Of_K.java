package Sub_array_2;

import java.util.*;

public class Count_Distinct_Elements_Window_Of_K {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		List<Integer> res = countDistinct(arr, k);
		for (int ele : res)
			System.out.print(ele + " ");
	}

	private static List<Integer> countDistinct(int[] arr, int k) {
		int n = arr.length;
		Map<Integer,Integer> freqMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(int i = 0;i < k;i++) {
			freqMap.put(arr[i],freqMap.getOrDefault(arr[i], 0) + 1);
		}
		result.add(freqMap.size());
		for(int i = k;i<n;i++) {
			int out = arr[i - k];
			int in = arr[i];
			freqMap.put(out,freqMap.get(out) - 1);
			if(freqMap.get(out) == 0) {
				freqMap.remove(out);
			}
			freqMap.put(in,freqMap.getOrDefault(in, 0)+1);
			result.add(freqMap.size());
		}
		return result;
	}

}
