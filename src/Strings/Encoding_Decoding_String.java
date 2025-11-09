package Strings;
import java.util.*;
public class Encoding_Decoding_String {
	public static String Decode(String S) {
		Stack <Integer> NumStack = new Stack<>();
		Stack <StringBuilder> StrStack = new Stack<>();
		int current_num = 0;
		StringBuilder current_String = new StringBuilder();
		for(char c : S.toCharArray()) {
			if(Character.isDigit(c)){
				current_num = current_num*10 +(c - '0');
			}else if(c == '[') {
				NumStack.push(current_num);
				StrStack.push(current_String);
				
				current_num = 0;
				current_String = new StringBuilder();
			}else if(c == ']') {
				int repeat_times = NumStack.pop();
				StringBuilder prev_String = StrStack.pop();
				for(int i =0;i<repeat_times;i++) {
					prev_String.append(current_String);
				}
				current_String = prev_String;
			}else {
				current_String.append(c);
			}
		}
		return current_String.toString();
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The String : ");
		String S = in.nextLine();
		String Decoded_String = Decode(S);
		System.out.println("The Decoded String is : " + Decoded_String);
		in.close();
	}
}
