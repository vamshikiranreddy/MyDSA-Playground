package Binary;

import java.util.*;

public class Generate_All_BinaryString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The String");
		int n = in.nextInt();
		List<StringBuilder> result = BinaryGeneration(n);
		System.out.println("The BinaryStrings Are : -");
		for (StringBuilder string : result) {
			System.out.print(string + " ");
		}
		in.close();
	}

	private static List<StringBuilder> BinaryGeneration(int n) {
		List<StringBuilder> result = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		recursive(n, str, result);
		return result;
	}

	private static void recursive(int n, StringBuilder str, List<StringBuilder> result) {
		if (str.length() == n) {
			result.add(new StringBuilder(str));
			return;
		}
		// Add 0
		str.append("0");
		recursive(n, str, result);
		str.deleteCharAt(str.length() - 1);

		// Add 1
		str.append("1");
		recursive(n, str, result);
		str.deleteCharAt(str.length() - 1);
	}

}
