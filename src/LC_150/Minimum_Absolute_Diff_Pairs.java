package LC_150;
import java.util.*;
public class Minimum_Absolute_Diff_Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of The Array : ");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The The Array Elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		List<List<Integer>> result = M_A_D(arr);
		System.out.println("The list with abs ");
		for(List<Integer> list : result) {
			System.out.print(list);
		}
	}

	private static List<List<Integer>> M_A_D(int[] arr) {
		Arrays.sort(arr);
		int minimum = Integer.MAX_VALUE;
		int diff;
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 1;i<n;i++) {
			diff = arr[i-1] - arr[i];
			if(diff < minimum) {
				result.clear(); // we only need pair with the minimum diffrence
				minimum = diff;
				result.add(new ArrayList<>(Arrays.asList(arr[i-1],arr[i])));
			}else if(diff == minimum) {
				result.add(new ArrayList<>(Arrays.asList(arr[i-1],arr[i])));
			}
		}
		return result;
	}

}
