package NUMBERs;
import java.util.*;
public class EvenDigitsOfAnNum {
	public  static ArrayList<Integer> EvenDigit(int[]array){
		ArrayList <Integer> result = new ArrayList<>();
		for(int num :array) {
			int digit = String.valueOf(num).length();
			if(digit % 2 == 0 ){
				result.add(num);
			}
		}
		return result;
	}
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size : ");
		int size = in.nextInt();
		int [] array = new int[size];
		System.out.println("Enter The Elements");
		for(int i =0;i<size;i++) {
			array[i] = in.nextInt();
		}
		ArrayList <Integer> Answer = EvenDigit(array);
		System.out.println(Answer);
		in.close();
	}
}
