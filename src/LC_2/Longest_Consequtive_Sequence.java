package LC_2;
import java.util.*;


public class Longest_Consequtive_Sequence {
	public static int Longest_Consequtive(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		HashSet<Integer> Set = new HashSet<>();
		for(int num : array) {
			Set.add(num);
		}
		int longeststreak = 0;
		for(int num : Set) {
			if(!Set.contains(num-1)) {
				int currentnum = num;
				int currentstreak = 1;
				while(Set.contains(currentnum+1)) {
					currentnum++;
					currentstreak++;
				}
				longeststreak = Math.max(longeststreak, currentstreak);
			}
		}
		return longeststreak;
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
		int result = Longest_Consequtive(array);
		System.out.println("The Longest Consequtive Sequence : " + result);
		in.close();
	}

}
