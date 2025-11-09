package Binary_Search_2;

public class Peak_Element {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        int result = Peak(nums);

        System.out.println("The Peak element is: " + result);
    }

    private static int Peak(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid; // found peak
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1; // go right
            } else {
                high = mid - 1; // go left
            }
        }
        return -1; // shouldn't happen for valid input
    }
}
