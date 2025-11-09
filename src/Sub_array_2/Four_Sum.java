package Sub_array_2;

import java.util.*;

public class Four_Sum {
	public static List<List<Integer>> Four_Sum_1(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						long sum = nums[i] + nums[j];
						sum += nums[k];
						sum += nums[l];
						if (sum == target) {
							List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
							Collections.sort(list);
							set.add(list);
						}
					}
				}
			}

		}
		result.addAll(set);
		return result;
	}

	public static List<List<Integer>> Four_Sum_2(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				Set<Integer> seen = new HashSet<>();
				for (int k = j + 1; k < n; k++) {
					long sum = target - (nums[i] + nums[j] + nums[k]);
					if (seen.contains((int)sum)) {
						List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], (int) sum));
						Collections.sort(list);
						set.add(list);
					}
					seen.add(nums[k]);
				}
			}
		}
		result.addAll(set);
		return result;
	}

	public static List<List<Integer>> Four_Sum_3(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1;
				int l = n - 1;
				while (k < l) {
					long sum = nums[i] + nums[j];
					sum += nums[k];
					sum += nums[l];
					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						l--;
						while (k < l && nums[k] == nums[k - 1])
							k++;
						while (k < l && nums[l] == nums[l + 1])
							l++;
					} else if (sum < target)
						k++;
					else
						l--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements :- ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter The Target = ");
		int target = in.nextInt();
		System.out.println("The Unique quadralets which sum to the target" + target
				+ "are (i != j != k != l) unique indeces O(N^3) + O (nlogn) :- ");
		List<List<Integer>> result_1 = Four_Sum_1(arr, target);
		System.out.println(result_1);
		System.out.println("The Unique quadralets which sum to the target" + target
				+ "are (i != j != k != l) unique indeces O(N^2) + O(nlogn) :- ");
		List<List<Integer>> result_2 = Four_Sum_2(arr, target);
		System.out.println(result_2);
		System.out.println("The Unique quadralets which sum to the target" + target
				+ "are (i != j != k != l) unique indeces O(N^2) + O (nlogn) :- ");
		List<List<Integer>> result_3 = Four_Sum_3(arr, target);
		System.out.println(result_3);
		in.close();
	}

}
