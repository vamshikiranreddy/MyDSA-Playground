package Arrays_Sort_freq;

import java.util.*;

public class Decreasing_freq {
	public static int[] sortByDecreasingFrequency(int[] nums) {
		HashMap<Integer,Integer> Map = new HashMap<>();
		for(int num : nums) {
			Map.put(num,Map.getOrDefault(num,0)+1);
		}
		Integer [] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		Arrays.sort(arr,(a,b) -> {
			int freqA = Map.get(a);
			int freqB = Map.get(b);
			return (freqA == freqB) ? Integer.compare(b,a) : Integer.compare(freqA,freqB);
		});
		return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] sortedNums = sortByDecreasingFrequency(nums);
        System.out.println("Sorted array by frequency (descending):");
        System.out.println(Arrays.toString(sortedNums));

        sc.close();
    }

	
}