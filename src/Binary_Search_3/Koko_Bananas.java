package Binary_Search_3;

public class Koko_Bananas {
	public static void main(String[] args) {
		int[] v = { 7, 15, 6, 3 };
		int h = 8;
		int ans = minimumRateToEatBananas(v, h);
		System.out.println("Koko should eat at least " + ans + " bananas/hr.");
	}

	private static int minimumRateToEatBananas(int[] piles, int h) {
		int max = findMax(piles);
		int low = 1;
		int high = max;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			int TotalTime = FindTime(middle, piles);
			if (TotalTime <= h) { // check left for any other min
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return low;
	}

	private static int FindTime(int middle, int[] piles) {
		int TotalTime = 0;
		for (int i = 0; i < piles.length; i++) {
			TotalTime += Math.ceil((double) piles[i] / (double) middle);
		}
		return TotalTime;
	}

	private static int findMax(int[] piles) {
		int max = 0;
		for (int i = 0; i < piles.length; i++) {
			max = Math.max(max, piles[i]);
		}
		return max;
	}

}
