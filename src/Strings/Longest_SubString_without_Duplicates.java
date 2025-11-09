package Strings;
import java.util.*;
public class Longest_SubString_without_Duplicates {
	private static int Long(String s) {
		int start = 0;
		int end = 0;
		int max = 0;
		List<Character> list = new ArrayList<>(); // or use hash set
		while(end<s.length()) {
			if(!list.contains(s.charAt(end))) {
				list.add(s.charAt(end));
				end++;
				max = Math.max(max, list.size());
			}else {
				list.remove(Character.valueOf(s.charAt(start)));
				start++;
			}
		}
		
		return max;
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The String : ");
		String s = in.nextLine();
		int max = Long(s);
		System.out.println("The Length Of Longest SubString wthout Duplicates is : "+ max);
		in.close();
	}

	
}
