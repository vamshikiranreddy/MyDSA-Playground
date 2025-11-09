package Bucket_Sort;

import java.util.*;

public class K_frequent_Elements {
	private static ArrayList<Integer> k_large(int[] array, int k) {
		int n = array.length;

		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : array) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		List<Integer>[] Bucket = new List[n + 1];
		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (Bucket[frequency] == null) {
				Bucket[frequency] = new ArrayList<>();
			}
			Bucket[frequency].add(key);
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = Bucket.length - 1; i >= 0 && result.size() < k; i--) {
			if (Bucket[i] != null) {
				for (int num : Bucket[i]) {
					result.add(num);
					if (result.size() >= k) {
						break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = in.nextInt();
		}
		System.out.println("Enter The k : ");
		int k = in.nextInt();
		ArrayList<Integer> result = k_large(array, k);
		for (int num : result) {
			System.out.print(num + " ");
		}
		in.close();

	}
}
