package Stack_And_Queue_3;

import java.util.*;

public class Next_Smaller_Element {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 10, 8 };
		int[] result = findNextSmaller(arr);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	private static int[] findNextSmaller(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int[] result = new int[n];
		Arrays.fill(result, -1);

		for (int i = 0; i < n; i++) {
			int num = arr[i];

			while (!st.isEmpty() && arr[st.peek()] > num) {
				result[st.pop()] = num;
			}

			if (i < n)
				st.push(i);
		}

		return result;
	}

}
