package BackTracking;

import java.util.*;

public class SubSets_2 {

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
		List<List<Integer>> result = SubSet(nums);
		for (List<Integer> list : result) {
			System.out.print(list + " ");
		}

	}

	private static List<List<Integer>> SubSet(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		recursion(0,nums,new ArrayList<>(),result);
		return result;
	}

	private static void recursion(int idx, int[] nums, ArrayList<Integer> currList, List<List<Integer>> result) {
		result.add(new ArrayList<>(currList));
		for(int i = idx;i<nums.length;i++) {
			if(i > idx && nums[i] == nums[i - 1]) continue;
			currList.add(nums[i]);
			recursion(i + 1,nums,currList,result);
			currList.remove(currList.size()-1);
		} 
		
	}

}
