package Strings_2;

import java.util.*;
import java.io.*;

public class Common_characters_in_an_Array {
	private static List<String> Freq(String[] words) {
		HashMap<Character, Integer> min_map = new HashMap<>();
		for (char ch : words[0].toCharArray()) {
			min_map.put(ch, min_map.getOrDefault(ch, 0) + 1);
		}
		for (int i = 1; i < words.length; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			for (char ch : words[i].toCharArray()) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
			for (char ch : min_map.keySet()) {
				if (map.containsKey(ch)) {
					min_map.put(ch, Math.min(min_map.get(ch), map.get(ch)));
				} else {
					min_map.put(ch, 0);
				}
			}
		}
		List<String> result = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : min_map.entrySet()) {
			int count = entry.getValue();
			for (int i = 0; i < count; i++) {
				result.add(String.valueOf(entry.getKey()));
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter The Size : ");
		int size = Integer.parseInt(br.readLine());
		System.out.println("Enter The Words");
		String words[] = new String[size];
		for (int i = 0; i < size; i++) {
			words[i] = br.readLine();
		}
		List<String> result = Freq(words);
		for (String word : result) {
			System.out.print(word + " ");
		}
	}
}

