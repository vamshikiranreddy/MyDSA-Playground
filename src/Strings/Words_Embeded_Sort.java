package Strings;
import java.util.*;
public class Words_Embeded_Sort {
	public static String Sort(String words[]) {
		HashMap <Integer,String> sorted = new HashMap<>();
		for(String word : words) {
			for(char c : word.toCharArray()) {
				if(Character.isDigit(c)) {
					sorted.put(Character.getNumericValue(c), word.replaceAll("\\d",""));
				}
			}
		}
		return String.join(" ", sorted.values()); 
	}
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array : ");
		int size = in.nextInt();
		in.nextLine();
		String Words [] = new String [size];
		System.out.println("Enter The Values : ");
		for(int i = 0;i<size;i++) {
			Words[i] = in.nextLine();
		}
		String sorted  = Sort(Words);
		System.out.println(sorted);
		in.close();
		
	}
}
