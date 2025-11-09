package Arrays;

public class Container_With_MostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left; // always positive
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move pointer from the shorter side
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max water area: " + maxArea(height)); // Output: 49
    }
}
