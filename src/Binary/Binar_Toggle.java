package Binary;
import java.util.*;
public class Binar_Toggle {
	private static int To_Binary_Toggle(int n) {
		String binary = Integer.toBinaryString(n);
		StringBuilder result = new StringBuilder();
		for(char c : binary.toCharArray()) {
			result.append(c == '0' ? '1': '0');
		}
		int res = Integer.parseInt(result.toString(),2);
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Integer : ");
		int N = in.nextInt();
		int result = To_Binary_Toggle(N);
		System.out.println("The Integer After Toggling : ");
		System.out.print(result);
		in.close();

	}
}
