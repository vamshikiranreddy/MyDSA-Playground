package Sliding_Window;

public class Maximum_Points_You_Can_Obtain_from_Cards {

	public static void main(String[] args) {

		int[] cardPoints = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
		int k = 4;

		int result = maxScore(cardPoints, k);
		System.out.println("Maximum points obtainable: " + result);
	}

	public static int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;

		int leftSum = 0, rightSum = 0;

		// Take first k cards from the left
		for (int i = 0; i < k; i++) {
			leftSum += cardPoints[i];
		}

		int maxSum = leftSum;
		int rightIdx = n - 1;

		// Replace left cards with right cards one by one
		for (int i = k - 1; i >= 0; i--) {
			leftSum -= cardPoints[i];
			rightSum += cardPoints[rightIdx--];
			maxSum = Math.max(maxSum, leftSum + rightSum);
		}

		return maxSum;
	}
}
