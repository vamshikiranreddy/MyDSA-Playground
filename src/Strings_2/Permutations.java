package Strings_2;
import java.util.*;
public class Permutations {
	public static boolean checkpermutation(String s1,String s2 ){
		if(s1.length()>s2.length() || s2.length()==0) {
			return false;
		}
		if(s1.length() == 0) {
			return true;
		}
		int x = s1.length();
		int y = s2.length();
		int [] array_s1 = new int [26]; 
		int [] array_s2 = new int [26];
		for(int i = 0;i<x;i++) {
			array_s1[s1.charAt(i) - 'a']++;
			array_s2[s2.charAt(i) - 'a']++;
		}
		for(int i =x;i<y;i++) {
			if(Arrays.equals(array_s1, array_s2)){
				return true;
			}
			array_s2[s2.charAt(i-x) - 'a']--;
			array_s2[s2.charAt(i) - 'a']++;
		}
		if(Arrays.equals(array_s1,array_s2)) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the First String:");
		String s1 = in.nextLine();
		System.out.println("Enter The Second String:");
		String s2 = in.nextLine();
	    boolean result = checkpermutation(s1,s2);
	    if(result) {
	    	System.out.println(" Substring  found !!!!");
	    }else {
	    	System.out.println("Substring not found  !!!!");
	    }
		in.close();
	}
	

}
