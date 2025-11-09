package Greedy_2;

public class JumpGame_2 {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("Minimum jumps: " + jump(nums)); // Expected: 2
	}

	private static int jump(int[] nums) {
		int jumps = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length - 1) {
			int farther = 0;
			for (int i = left; i <= right; i++) {
				farther = Math.max(farther, i + nums[i]);
			}
			left = right + 1;
			right = farther;
			jumps++;
		}
		return jumps;
	}

}
