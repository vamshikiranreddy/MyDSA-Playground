package Sub_array_2;
import java.util.*;

public class Max_Sum_Subarray_of_size_K {

    // Sliding window approach
    public int maximumSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0; // safety check

        int sum = 0, maxSum;

        // First window sum
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        // Slide the window
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k]; // add new, remove old
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // Sliding window with List (less efficient but illustrative)
    public int maximumSumSubarray_List(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0; // safety check

        List<Integer> window = new ArrayList<>();
        int start = 0, end = 0, sum = 0, maxSum = Integer.MIN_VALUE;

        while (end < n) {
            sum += arr[end];
            window.add(arr[end]);
            end++;

            if (window.size() == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= window.get(0); // remove first element's value
                window.remove(0);     // remove first element from list
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Max_Sum_Subarray_of_size_K obj = new Max_Sum_Subarray_of_size_K();

        int[] arr = {100, 200, 300, 400};
        int k = 2;

        System.out.println("Max sum (array method): " + obj.maximumSumSubarray(arr, k));
        System.out.println("Max sum (list method): " + obj.maximumSumSubarray_List(arr, k));
    }
}
