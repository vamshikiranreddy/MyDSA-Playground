	package Binary_Search_2;
	
	public class Peak_2DArray {
	
		public static void main(String[] args) {
			int[][] mat = { { 10, 8, 10, 10 }, { 14, 13, 12, 11 }, { 15, 9, 11, 21 }, { 16, 17, 19, 20 } };
	
			int[] peak = findPeakGrid(mat);
			System.out.println("Peak found at row = " + peak[0] + ", col = " + peak[1]);
			System.out.println("Peak value = " + mat[peak[0]][peak[1]]);
	
		}
	
		private static int[] findPeakGrid(int[][] mat) {
			int m = mat.length;
			int n = mat[0].length;
			int low = 0, high = n - 1;
			while (low <= high) {
				int midCol = low + (high - low) / 2;
				int maxRowIdx = findMax(mat, m, n, midCol);
	
				int left = midCol - 1 >= 0 ? mat[maxRowIdx][midCol - 1] : -1;
				int right = midCol + 1 < n ? mat[maxRowIdx][midCol + 1] : -1;
				if (mat[maxRowIdx][midCol] > left && mat[maxRowIdx][midCol] > right) {
					return new int[] { maxRowIdx, midCol };
				} else if (mat[maxRowIdx][midCol] < right) {
					low = midCol + 1;
				} else {
					high = midCol - 1;
				}
			}
			return new int[] { -1, -1 };
		}
	
		private static int findMax(int[][] mat, int m, int n, int midCol) {
			int max = Integer.MIN_VALUE;
			int maxIdx = -1;
			for (int i = 0; i < m; i++) {
				if (mat[i][midCol] > max) {
					max = mat[i][midCol];
					maxIdx = i;
				}
			}
			return maxIdx;
		}
	
	}
