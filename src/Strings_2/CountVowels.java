package Strings_2;
import java.util.*;
public class CountVowels {
	public static void Count(String str) {
		int vowel_count=0;
		int consonent_count=0;
		int digit_count=0;
		int spl_count = 0;
		str = str.toLowerCase();
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowel_count++;
			} else if (ch >= 'a' && ch <= 'z') {
                consonent_count++;
            }
            else if (ch >= '0' && ch <= '9') {
                digit_count++;
            }
            else {
                spl_count++;
            }
		}
		System.out.println("Vowels: " + vowel_count);
        System.out.println("Consonants: " + consonent_count);
        System.out.println("Digits: " + digit_count);
        System.out.println("Special Characters: " + spl_count);
	}
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = sc.nextLine();
		Count(str);
	}

}
