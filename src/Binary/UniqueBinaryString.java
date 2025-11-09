package Binary;
import java.util.*;
public class UniqueBinaryString {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size:");
		int size = in.nextInt();
		String [] arr = new String[size];
		for(int i = 0;i<size;i++) {
			arr[i] = in.nextLine();
		}
		String Unq = Binary(arr);
		System.out.println("The Unq String is" + Unq);
		in.close();
	}

	private static String Binary(String[] arr) {
		StringBuilder result = new StringBuilder();
		for(int i = 0;i<arr.length;i++) {
			result.append(arr[i].charAt(i) == 0 ? 1 :0);
		}
		return result.toString();
	}
	
}
