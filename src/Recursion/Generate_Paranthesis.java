package Recursion;

import java.util.*;

public class Generate_Paranthesis {

	public static void main(String[] args) {
		int n = 3;
		List<String> result = generateParenthesis(n);

		System.out.println("All valid parentheses combinations for n = " + n + ":");
		for (String s : result) {
			System.out.print(s + " || ");

		}
	}

	private static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		recursiveBacktrack(n,str,result,0,0);
		return result;
	}

	private static void recursiveBacktrack(int n, StringBuilder str, List<String> result, int openCnt, int closeCnt) {
		if(str.length() == 2 * n) {
			result.add(str.toString());
			return;
		}
		//Add Closing
		if(openCnt < n) {
			str.append('(');
			recursiveBacktrack(n,str,result,openCnt + 1,closeCnt);
			str.deleteCharAt(str.length()-1);
		}
		if(closeCnt < openCnt) {
			str.append(')');
			recursiveBacktrack(n,str,result,openCnt,closeCnt + 1);
			str.deleteCharAt(str.length()-1);
			
		}
	}

}
