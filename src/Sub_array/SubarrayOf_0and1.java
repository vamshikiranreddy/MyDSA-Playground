package Sub_array;
import java.util.*;
public class SubarrayOf_0and1 {
	public static int count(String input) {
		int count = 0;
		int count0 = 0,count1 = 1;
		for(int i = 0;i<input.length();i++) {
			for(int j = i;j<input.length();j++) {
				if(input.charAt(j) == '0') {
					count0++;
				}else {
					count1++;
				}
				if(count0 == count1) {
					count++;
				}
			}
		}
		
		return count;
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String in 0's and 1's :");
		String input = in.nextLine();
		int result = count(input);
		System.out.println("The Count Of The SubArrays Are : " + result);
		in.close();
	}
}
