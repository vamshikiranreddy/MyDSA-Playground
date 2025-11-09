package Stack_2;

import java.util.*;

public class RemoveStars {
	public static String removeStars(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '*') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(ch);
			}
		}

		StringBuilder result = new StringBuilder();
		for (char ch : stack) {
			result.append(ch);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string with stars (*): ");
		String input = scanner.nextLine();

		String output = removeStars(input);

		System.out.println("String after removing stars: " + output);

		scanner.close();
	}
}
