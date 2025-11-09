package Bucket_Sort;

import java.util.*;

public class Sort_Characters_By_Frequency {
	private static String Bucket_Sort(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		List<Character> [] Bucket = new ArrayList [s.length()+1];
		for(char ch : map.keySet()) {
			int freq = map.get(ch);
			if(Bucket[freq] == null) {
				Bucket[freq] = new ArrayList<>();
			}
			Bucket[freq].add(ch);
		}
		for(List<Character> bucket : Bucket) {
			if(bucket != null) {
				Collections.sort(bucket);
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = Bucket.length-1;i>=0;i--) {
			if(Bucket[i] != null) {
				for(char ch : Bucket[i]) {
					result.append(String.valueOf(ch).repeat(i));
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The String : ");
		String s = in.nextLine();
		String result = Bucket_Sort(s);
		System.out.println("The Sorted String based On freq :" + result);
		in.close();
	}

}
