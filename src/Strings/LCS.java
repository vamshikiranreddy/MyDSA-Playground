package Strings;
import java.util.*;
public class LCS {
	public static String Lcs(String s1,String s2) {
		int m = s1.length();
		int n = s2.length();
		// First Create The Dp Table And Fill
		int DP [][] = new int[m+1][n+1];
		for(int i=1;i<m;i++) {
			for(int j =1;j<n;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					DP[i][j] = DP[i-1][j-1] +1;
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
		
		// Root Through The LCS
		
		StringBuilder lcs = new StringBuilder();
		int i = m,j = n;
		while(i>0 && j>0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				lcs.append(s2.charAt(j-1));     // it's ok even if it is s1.charAt(i-1) because it's the same
				i--;
				j--;
			}else if(DP[i-1][j]>DP[i][j-1]){
				i--;
			}else {
				j--;
			}
		}
		return lcs.reverse().toString();
	}
	public static void main(String[]args) {
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter The First Word : ");
		String s1 = in.nextLine();
		System.out.println("Enter The Second Word : ");
		String s2 = in.nextLine();
		
		System.out.println("The Longest Common Subsequence is = "+Lcs(s1,s2));
		in.close();
	}
}
