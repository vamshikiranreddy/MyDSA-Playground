package Next_Greater;
import java.util.*;
public class Circular_array {
	public static int [] Next_Greater_Num(int [] array){
		int n = array.length;
		Stack<Integer> stack = new Stack<>();
		int [] result = new int [n];
		Arrays.fill(result, -1);
		for(int  i = 0;i<2*n;i++){
			int num = array[i%n];
			while(!stack.isEmpty() && array[stack.peek()] < num) {
				result[stack.pop()] = num;
			}
			if(i<n) {
				stack.push(i);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Array");
		int size = in.nextInt();
		System.out.println("Enter The Elements");
		int [] array = new int[size];
		for(int i =0;i<size;i++) {
			array [i] = in.nextInt();
		}
		int result [] = Next_Greater_Num(array);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+",");
		}
		in.close();
	}

}
