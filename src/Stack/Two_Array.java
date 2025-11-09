package Stack;
import java.util.*;
public class Two_Array {
	public static int [] Next_Greater_Num(int [] array1,int[]array2) {
		//array1 is the subset of array2 
		Stack <Integer> stack = new Stack<>();
		HashMap<Integer,Integer> hash = new HashMap<>();
		for(int num: array2) {
			while(!stack.isEmpty() && stack.peek() < num) {
				hash.put(stack.pop(),num);
			}
			stack.push(num);
		}
		while(!stack.isEmpty()) {
			hash.put(stack.pop(), -1);
		}
		int []  result = new int[array1.length];
		for(int i = 0;i<array1.length;i++) {
			result[i] = hash.get(array1[i]);
		}
		return result;
	}
	public static void main(String[]args) {
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter The Size Of Array One ");
		int size1 = in.nextInt();
		System.out.println("Enter The Elements");
		int [] array_1 = new int[size1];
		for(int i =0;i<size1;i++) {
			array_1 [i] = in.nextInt();
		}
		System.out.println("Enter The Size Of Array Two ");
		int size2 = in.nextInt();
		int [] array_2 = new int[size2];
		System.out.println("Enter The Elements");
		for(int i =0;i<size2;i++) {
			array_2 [i] = in.nextInt();
		}
		int [] result = Next_Greater_Num(array_1,array_2);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
		in.close();
	}
}
