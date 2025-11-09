package Recursion_2;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {

	public static void main(String[] args) {
		String digits = "23"; 
		List<String> output = letterCombinations(digits);
		System.out.println("Combinations for " + digits + ": " + output);

	}

	private static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		Map<Character,String> map = new HashMap<>();
		map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        recursion(0,sb,digits,result,map);
		return result;
	}

	private static void recursion(int idx, StringBuilder sb, String digits, List<String> result,Map<Character, String> map) {
		if(idx == digits.length()) {
			result.add(sb.toString());
			return;
		}
		String letters = map.get(digits.charAt(idx));
		for(char ch : letters.toCharArray()) {
			sb.append(ch);
			recursion(idx + 1,sb,digits,result,map);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}

}
