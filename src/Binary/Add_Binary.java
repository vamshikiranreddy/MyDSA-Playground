package Binary;
import java.util.*;
public class Add_Binary {
	public static String addBinary(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0 || carry != 0) {
			int sum = carry;
			if (i >= 0) {
				sum += s1.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += s2.charAt(j--) - '0';
			}
			result.append(sum % 2);
			carry = sum / 2;
		}

		// Remove leading zeros
		while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
			result.setLength(result.length() - 1);
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The First String");
		String s1 = in.nextLine();
		System.out.println("Enter The Second String");
		String s2 = in.nextLine();
		System.out.println(addBinary(s1, s2)); // Expected Output: "1111110"
		
		in.close();
	}
}
