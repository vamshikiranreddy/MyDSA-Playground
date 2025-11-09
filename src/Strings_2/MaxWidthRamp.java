package Strings_2;
import java.util.*;
public class MaxWidthRamp {
	public static int MaxWidthRamp(int [] nums){
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		for(int i=0;i<n;i++) {
			if(stack.empty() || nums[stack.peek()]>nums[i]){
				stack.push(i);
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--){
			while(!stack.empty() && nums[stack.peek()]<=nums[i]) {
				ans = Math.max(ans,i-stack.pop());
			}
			if(stack.empty()) {
				break;
			}
		}
		
	return ans;
	}
	public static void main(String[] args) {
		Scanner in =  new Scanner (System.in);
		System.out.println("Enter THe Size : ");
		int size = in.nextInt();
		int []nums = new int [size];
		System.out.println("Enter The Elements : ");
		for(int  i =0;i<size;i++){
			nums[i] = in.nextInt();
		}
		int result = MaxWidthRamp(nums);
		System.out.println("The Maximum Width Of the Array :"+ result);

	}

}
