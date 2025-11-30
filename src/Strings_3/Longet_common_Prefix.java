package Strings_3;
import java.util.*;
public class Longet_common_Prefix {
	private static int Logest_prefix(String s, String t) {
		int S = s.length();
		int T = t.length();
		int i =0;
		int j =0;
		int count =0;
		while(i<S && j<T) {
			if(s.charAt(i) == s.charAt(j)) {
				count++;
				i++;
				j++;
			}else {
				j++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The First String : ");
		String s = in.nextLine();
		System.out.println("Enter The Second String : ");
		String t = in.nextLine();
		int result = Logest_prefix(s,t);
		System.out.println(result);
		in.close();

	}



}
