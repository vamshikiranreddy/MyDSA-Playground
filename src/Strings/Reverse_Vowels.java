package Strings;

import java.util.*;

public class Reverse_Vowels {
	public static String Reverse_Vowel(String S) {
		char arr[] = S.toCharArray();
		int left = 0;
		int right = arr.length - 1;
		String Vowels = "aeiouAEIOU";
		while (left < right) {
			while (left < right && Vowels.indexOf(arr[left]) == -1) {
				left++;
			}
			while (left < right && Vowels.indexOf(arr[right]) == -1) {
				right--;
			}
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The String : ");
		String S = in.nextLine();
		String result = Reverse_Vowel(S);
		System.out.println("The Reversed Vowel Sequence : " + result);
		in.close();
	}
}
