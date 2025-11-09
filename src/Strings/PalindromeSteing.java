package Strings;
import java.util.*;
public class PalindromeSteing {
	public static void main(String[]args) {
		// normal method
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The String:");
		String str = in.nextLine();
		/*
		String rev_str="";
		int length = str.length();
		for(int i =length-1;i>=0;i--) {
			rev_str += str.charAt(i); 
		}
		if(rev_str.equals(str)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		*/
		//String Builder 
		StringBuilder sb = new StringBuilder(str);
		String rev_str = sb.reverse().toString();
		if(rev_str.equals(str)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
