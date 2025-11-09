package Binary_Search_2;

public class Single_Element {
	
	public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        
        int low = 1;
        int high = n - 2;
        
        while (low <= high) {
            int middle = low + (high - low) / 2;
            
            if (nums[middle] != nums[middle - 1] && nums[middle] != nums[middle + 1]) {
                return nums[middle];
            }
            
            if ((middle % 2 == 0 && nums[middle] == nums[middle + 1]) ||
                (middle % 2 == 1 && nums[middle] == nums[middle - 1])) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        
        int result = singleNonDuplicate(nums);
        
        System.out.println("The single element is: " + result);
    }
}
