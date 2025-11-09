package Strings;
import java.util.*;
public class StringDuplicate {
	public static String [] removeDuplicates(String[]array){
		HashSet <String> UniqueSet = new HashSet<>(Arrays.asList(array));
		
		return UniqueSet.toArray(new String[0]);
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size : ");
		int size = in.nextInt();
		in.nextLine();
		System.out.println("Enter The Elements : ");
		String [] array = new String[size];
		for(int i =0;i<size;i++) {
			array[i] = in.nextLine();
		}
		String[] result = removeDuplicates(array);
		System.out.println(Arrays.toString(result));
		in.close();
	}
}
