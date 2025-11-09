package Sub_array_2;

import java.util.*;

public class Three_Sum {

	// O(N^3) + O (nlogn)
	public static List<List<Integer>> Three_Sum_1(int[] nums) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
						Collections.sort(temp);
						set.add(temp);
					}
				}
			}
		}
		result.addAll(set);
		return result;
	}

	// O(N^2) + O(nlogn)
	public static List<List<Integer>> Three_Sum_2(int[] nums) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			Set<Integer> set_seen = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int sum = -(nums[i] + nums[j]);
				if (set_seen.contains(sum)) {
					List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], sum));
					Collections.sort(temp);
					set.add(temp);
				}
				set_seen.add(nums[j]);
			}
		}
		result.addAll(set);
		return result;
	}

	// O(N^2) + O (nlogn)

	public static List<List<Integer>> Three_Sum_3(int[] nums) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
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
		System.out.println("The Unique Triplets are (i != j != k) unique indeces O(N^3) + O (nlogn) :- ");
		List<List<Integer>> result_1 = Three_Sum_1(arr);
		System.out.println(result_1);
		System.out.println("The Unique Triplets are (i != j != k) unique indeces O(N^2) + O(nlogn) :- ");
		List<List<Integer>> result_2 = Three_Sum_2(arr);
		System.out.println(result_2);
		System.out.println("The Unique Triplets are (i != j != k) unique indeces O(N^2) + O (nlogn) :- ");
		List<List<Integer>> result_3 = Three_Sum_3(arr);
		System.out.println(result_3);
		in.close();

	}

}
