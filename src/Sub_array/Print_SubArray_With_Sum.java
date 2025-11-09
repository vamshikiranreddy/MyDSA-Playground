package Sub_array;
import java.util.*;
public class Print_SubArray_With_Sum {
	public static void PrintSubArrays(int [] arr,int sum) {
		int n = arr.length;
		List <List<Integer>> resultList = new ArrayList<>();
		for(int i =0;i<n;i++) {
			int currentSum = 0;
			List<Integer> tempList = new ArrayList<>();
			for(int j=i;j<n;j++) {
				currentSum+=arr[j];
				tempList.add(arr[j]);
				if(currentSum == sum) {
					resultList.add(new ArrayList<>(tempList));
				}
			}
		}
		for(List<Integer> sub : resultList) {
			System.out.println(sub);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of The Array");
		int size = in.nextInt();
		System.out.println("Enter The Array Elements : ");
		int arr[] = new int[size];
		for(int i =0;i<size;i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("Enter The Sum ");
		int sum = in.nextInt();
		System.out.println("Subarrays with the given sum:");
		PrintSubArrays(arr,sum);
		in.close();
	}

}
