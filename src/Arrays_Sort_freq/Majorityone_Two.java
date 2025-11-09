package Arrays_Sort_freq;

import java.util.*;

public class Majorityone_Two {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 2, 2};

        // Majority Element I
        System.out.println("Majority Element (> n/2): " + majorityElementOne(nums));

        // Majority Element II
        System.out.println("Majority Elements (> n/3): " + majorityElementTwo(nums));
    }

    // Problem 1: Majority Element (> n/2)
    public static int majorityElementOne(int[] nums) {
        int candidate = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }
        return candidate; // Guaranteed to exist per problem statement
    }

    // Problem 2: Majority Element (> n/3)
    public static List<Integer> majorityElementTwo(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // First pass: Find candidates
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == candidate1) count1++;
            else if (n == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);

        return result;
    }
}
