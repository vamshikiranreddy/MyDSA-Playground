package Strings;
import java.util.*;
public class VowelArangement { 
	public static boolean IsVowel(char c ) {
		return c =='a'||c == 'e'||c == 'i'||c=='o'||c == 'u' ||c == 'A' ||c == 'E'||c =='I'|| c == 'O'||c == 'U';
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Words");
		String words = in.nextLine();
		
		String WORDS[] = words.split(" ");
		
		Arrays.sort(WORDS);
		System.out.println("The Words With vowels Are : ");
		for(int i =0;i<WORDS.length;i++) {
			if(IsVowel(WORDS[i].charAt(0))) {
				System.out.println( "->"+WORDS[i]);
			}
		}
		in.close();
	}

}
