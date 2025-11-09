package BackTracking;

import java.util.*;

public class SubsSet {

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
		for(List<Integer> list : result) {
			System.out.print(list + " ");
		}
	}

	private static List<List<Integer>> SubSet(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		RecursiveBackTrack(0,nums,new ArrayList<>(),result);
		return result;
	}

	private static void RecursiveBackTrack(int idx, int[] nums, ArrayList<Integer> current, List<List<Integer>> result) {
		if(idx == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}
		//take the num 
		current.add(nums[idx]);
		RecursiveBackTrack(idx+1,nums,current,result);
		current.remove(current.size()-1);
		// Create a subset without num
		RecursiveBackTrack(idx+1,nums,current,result);
		
	}

}
