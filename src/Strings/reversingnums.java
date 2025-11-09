package Strings;
import java.util.*;
public class reversingnums {
	public static String ReverseNum(String s){
		char [] arr = s.toCharArray();
		int i =0;
		int j= arr.length-1;
		while(i<j) {
			if(Character.isDigit(arr[i]) && Character.isDigit(arr[j])) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			if(!Character.isDigit(arr[i])) {
				i++;
			}else {
				j--;
			}
		}
		return new String(arr);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an Alphanumerical String : ");
		String s = in.nextLine();
		in.close();
		System.out.println("The string after the method is :" + ReverseNum(s));
	}

}
