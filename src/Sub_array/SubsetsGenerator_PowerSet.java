package Sub_array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetsGenerator_PowerSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input handling
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        // Generate subsets
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        
        // Output the results
        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        scanner.close();
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());  // Start with empty subset
        
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> existing : output) {
                List<Integer> temp = new ArrayList<>(existing);
                temp.add(num);
                newSubsets.add(temp);
            }
            output.addAll(newSubsets);
        }
        
        return output;
    }
}