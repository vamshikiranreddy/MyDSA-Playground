package Arrays;
import java.util.*;
public class RemoveDuplicatesInArray {
	public static int Duplicates(int [] nums) {
		int count = 0;
		for(int i = 0;i<nums.length;i++){
			if(i<nums.length-1 && nums[i] == nums[i+1]) {
				continue;
			}else {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter The Size Of The Sorted Array");
		int size = in.nextInt();
		int [] nums = new int [size];
		System.out.println("Enter The Elements : ");
		for(int i = 0;i<nums.length;i++) {
			nums[i] = in.nextInt();
		}
		int result = Duplicates(nums);
		System.out.println(result);
	}

}
