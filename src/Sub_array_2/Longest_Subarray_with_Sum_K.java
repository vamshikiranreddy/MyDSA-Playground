package Sub_array_2;

import java.util.HashMap;
import java.util.Map;

public class Longest_Subarray_with_Sum_K {

    public static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;  // Subarray from start to current index
            }

            if (prefixSumMap.containsKey(sum - k)) {
                int idx = prefixSumMap.get(sum - k);
                maxLen = Math.max(maxLen, i - idx);
            }

            prefixSumMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        int result = longestSubarray(arr, k);
        System.out.println("Length of longest subarray with sum " + k + " is: " + result);
    }
}
