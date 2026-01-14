package Stack_And_Queue;
import java.util.*;
public class Valid_Paranthesis {
	public static boolean isValid(String input) {
		Stack<Character> stack = new Stack<>();
		for(int  i =0;i<input.length();i++) {
			char c = input.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}else if (c == ')' || c == '}' || c == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if(c == ')' && top != '(') return false;
				if(c == '}' && top != '{') return false;
				if(c == ']' && top != '[') return false;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
        System.out.print("Enter a string with parentheses, brackets, or braces: ");
        String input = in.nextLine();
        boolean isValid = isValid(input);
        System.out.println("Is the string valid ? " + isValid);
        in.close();
	}

}
