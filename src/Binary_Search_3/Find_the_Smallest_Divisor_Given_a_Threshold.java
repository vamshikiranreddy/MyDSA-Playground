package Binary_Search_3;
import java.util.*;
public class Find_the_Smallest_Divisor_Given_a_Threshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int max = findMax(nums);
        int low = 1;         // divisor must be at least 1
        int high = max;      // largest divisor needed is max element

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = compute(nums, mid);

            if (sum <= threshold) {
                high = mid - 1;  // try smaller divisor
            } else {
                low = mid + 1;   // need larger divisor
            }
        }
        return low;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // compute sum of ceil(nums[i] / divisor)
    private int compute(int[] nums, int divisor) {
        int ans = 0;
        for (int num : nums) {
            // Trick: ceil(a/b) = (a + b - 1) / b (integer division)
            ans += Math.ceil((double) num/ (double)divisor);
        }
        return ans;
    }

    // quick test
    public static void main(String[] args) {
        Find_the_Smallest_Divisor_Given_a_Threshold solver = new Find_the_Smallest_Divisor_Given_a_Threshold();
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(solver.smallestDivisor(nums, threshold)); // Expected: 5
    }
}
