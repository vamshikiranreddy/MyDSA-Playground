package Binary_Search_4;

public class GasStations {

    public static void main(String[] args) {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // positions of existing stations
        int K = 9; // number of new stations to add

        Solution sol = new Solution();
        double result = sol.minMaxDist(stations, K);

        System.out.printf("Minimum possible maximum distance = %.6f\n", result);
    }
}

class Solution {
    public double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        double low = 0.0, high = stations[n - 1] - stations[0];
        double eps = 1e-6; // precision up to 6 decimal places

        while (high - low > eps) {
            double mid = (low + high) / 2.0;
            if (canPlace(stations, K, mid)) {
                high = mid; // try smaller maximum distance
            } else {
                low = mid; // need bigger distance
            }
        }
        return high;
    }

    private boolean canPlace(int[] stations, int K, double dist) {
        int required = 0;
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            // how many new stations needed in this gap
            required += (int) (gap / dist);
        }
        return required <= K;
    }
}
