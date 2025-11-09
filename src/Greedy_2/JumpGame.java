package Greedy_2;

public class JumpGame {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
       if(minJumps(arr)){
    	   System.out.println("Is Possible");
       }else {
    	   System.out.println("Not Possible");
       }

	}

	private static boolean minJumps(int[] arr) {
		int maxJump = 0;
		for(int i = 0;i<arr.length;i++) {
			if(i > maxJump) return false;
			maxJump = Math.max(maxJump, i + arr[i]);
		}
		return true;
	}

}
