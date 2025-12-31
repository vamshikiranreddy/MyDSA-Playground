package Sliding_Window_2;

public class Number_of_Substrings_Containing_All_Three_Characters {

	public static void main(String[] args) {
		String s = "abcabc";
		System.out.println("Optimal Solution 1 : " + numberOfSubstringsOptimalSol1(s));
		System.out.println("Optimal Solution 2 : " + numberOfSubstringsOptimalSol2(s));
	}

	private static int numberOfSubstringsOptimalSol1(String s) {
		int n = s.length();
		int[] counter = new int[3];
		int left = 0, right = 0, count = 0;
		while (right < n) {
			counter[s.charAt(right) - 'a']++;
			while (counter[0] > 0 && counter[1] > 0 && counter[2] > 0) {
				count += (n - right);
				counter[s.charAt(left) - 'a']--;
				left++;
			}
			right++;
		}
		return count;
	}

	private static int numberOfSubstringsOptimalSol2(String s) {
		int[] lastSeen = { -1, -1, -1 };
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			lastSeen[s.charAt(i) - 'a'] = i;

			if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {

				cnt += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
			}
		}
		return cnt;
	}

}
