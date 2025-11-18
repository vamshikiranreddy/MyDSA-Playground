package Binary_Search_4;

public class Painter_Partition {

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 45}; // length of each board
        int painters = 2; // number of painters

        int result = partition(boards, painters);
        System.out.println("Minimum time to paint all boards = " + result);
    }

    // Function to find minimum maximum length
    private static int partition(int[] boards, int painters) {
        int low = getMax(boards); // minimum possible (largest single board)
        int high = getSum(boards); // maximum possible (all boards by one painter)
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(boards, painters, mid)) {
                ans = mid;
                high = mid - 1; // try smaller maximum
            } else {
                low = mid + 1; // need bigger maximum
            }
        }
        return ans;
    }

    // Check if boards can be painted with maxLen allowed
    private static boolean isPossible(int[] boards, int painters, int maxLen) {
        int painterCount = 1;
        int currLen = 0;

        for (int board : boards) {
            if (currLen + board <= maxLen) {
                currLen += board;
            } else {
                painterCount++;
                currLen = board;
                if (painterCount > painters) return false;
            }
        }
        return true;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
