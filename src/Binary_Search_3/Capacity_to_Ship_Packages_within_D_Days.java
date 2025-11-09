package Binary_Search_3;

public class Capacity_to_Ship_Packages_within_D_Days {
	 public static void main(String[] args) {
	        int[] weights = {1,2,3,4,5,6,7,8,9,10};
	        int days = 5;
	        int ans = BinarySearch(weights, days);
	        System.out.println("Minimum capacity required = " + ans);
	    }

	private static int BinarySearch(int[] weights, int days) {
		int low = Integer.MIN_VALUE;
		int high = 0;
		for(int i = 0;i<weights.length;i++) {
			low = Math.max(low, weights[i]);
			high += weights[i];
		}
		while(low <= high) {
			int mid = low + (high - low)/2;
			int daysCount = Compute(weights,mid);
			if(daysCount <= days) {
				high = mid - 1;
			}else {
				low = mid+ 1;
			}
		}
		return low;
	}

	private static int Compute(int[] weights, int capacity) {
		int load = 0;
		int days = 1;
		for(int i = 0;i<weights.length;i++) {
			if(load + weights[i] > capacity) {
				days++;
				load = weights[i];
			}else {
				load += weights[i];
 			}
		}
		return days;
	}

}
