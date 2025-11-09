package Bucket_Sort;

import java.util.*;

public class K_Frequent_Words {
	public static ArrayList<String> Bucket_Sort(String[] words, int k) {
		int n = words.length;
		HashMap<String, Integer> FrequencyMap = new HashMap<>();
		for (String word : words) {
			FrequencyMap.put(word, FrequencyMap.getOrDefault(word, 0) + 1);
		}
		List<String>[] Bucket = new ArrayList[n + 1];
		for (String key : FrequencyMap.keySet()) {
			int frequency = FrequencyMap.get(key);
			if (Bucket[frequency] == null) {
				Bucket[frequency] = new ArrayList<>();
			}
			Bucket[frequency].add(key);
		}
		for (List<String> List : Bucket) {
			if (List != null) {
				Collections.sort(List);
			}
		}
		ArrayList<String> result = new ArrayList<>();
		int count = 0;
		for (int i = Bucket.length - 1; i >= 0 && count < k; i--) {
			if (Bucket[i] != null) {
				for (String word : Bucket[i]) {
					if (count < k) {
						result.add(word);
						count++;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array : ");
		int size = in.nextInt();
		in.nextLine();
		String[] words = new String[size];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < size; i++) {
			words[i] = in.nextLine();
		}
		System.out.println("Enter The K Value : ");
		int k = in.nextInt();
		ArrayList<String> result = Bucket_Sort(words, k);
		for (String word : result) {
			System.out.println(word + " ");
		}
		in.close();

	}

}
