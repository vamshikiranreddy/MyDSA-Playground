package Strings;
import java.util.*;
public class Reverse_String {
	public static String reverse_String(String str){
		String Strs [] = str.split(" +");
		StringBuilder sb = new StringBuilder();
		for(int i = Strs.length-1;i>=0;i--) {
			sb.append(Strs[i]);
			sb.append(" ");
		}
		return sb.toString().trim();
	}
	public static void main(String[]args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter The String : ");
		String  str = in.nextLine();
		String result = reverse_String(str);
		System.out.println("The Reverse of the String is : "+result);
		in.close();
	}
}
