package Stack_2;

import java.util.*;

public class BackSpace {
	public static boolean backspaceCompare(String s, String t) {
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '#') {
				if (!stack1.isEmpty()) {
					stack1.pop();
				}
			} else {
				stack1.push(ch);
			}
		}

		for (char ch : t.toCharArray()) {
			if (ch == '#') {
				if (!stack2.isEmpty()) {
					stack2.pop();
				}
			} else {
				stack2.push(ch);
			}
		}

		return stack1.equals(stack2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first string (s): ");
		String s = scanner.nextLine();

		System.out.print("Enter second string (t): ");
		String t = scanner.nextLine();

		boolean result = backspaceCompare(s, t);

		System.out.println("Are the strings equal after backspace processing? " + result);

		scanner.close();
	}
}
