package Sub_array;

import java.util.*;

public class two_Sum {
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; 
    }
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter elements: ");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        System.out.print("Choose approach (1 = Brute Force, 2 = Hash Map): ");
        int choice = sc.nextInt();
        int[] result;
        if(choice == 1) {
            result = twoSumBruteForce(nums, target);
        } else {
            result = twoSumHashMap(nums, target);
        }
        if(result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
            System.out.println("Values: " + nums[result[0]] + ", " + nums[result[1]]);
        } else {
            System.out.println("No valid pair found.");
        }

        sc.close();
    }
}
