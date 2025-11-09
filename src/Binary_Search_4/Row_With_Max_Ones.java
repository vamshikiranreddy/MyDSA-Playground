package Binary_Search_4;

import java.util.ArrayList;

public class Row_With_Max_Ones {

    // lower_bound implementation: finds first index where arr.get(mid) >= x
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) >= x) {
                ans = mid;
                high = mid - 1; // look for smaller index
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    // Function to find row with maximum 1s
    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(matrix.get(i), m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(java.util.Arrays.asList(0, 0, 0, 1)));
        matrix.add(new ArrayList<>(java.util.Arrays.asList(0, 1, 1, 1)));
        matrix.add(new ArrayList<>(java.util.Arrays.asList(0, 0, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        int ans = rowWithMax1s(matrix, n, m);
        System.out.println("Row with maximum 1s = " + ans);
    }
}
