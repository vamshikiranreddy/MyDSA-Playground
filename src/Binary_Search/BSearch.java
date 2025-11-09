package Binary_Search;
import java.util.*;
public class BSearch {
	private static int Binary_Search(int[] array,int target) {
		int n  = array.length;
		int low = 0;
		int high = n-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(array[mid] == target) {
				return mid;
			}else if(array[mid] < target){
				low = mid + 1;
			}else {
				high = mid-1;
			}
		}
		return low;
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
			System.out.println("Enter The Target : ");
			int target = in.nextInt();
			int index = Binary_Search(array,target);
			System.out.println("The Element "+ target + " at Index : " + index);
			in.close();
	}
}
