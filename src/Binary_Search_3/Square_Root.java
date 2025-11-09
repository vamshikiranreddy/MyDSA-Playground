package Binary_Search_3;

public class Square_Root {

    public static void main(String[] args) {
        int n = 37; // example input
        int result = mySqrt(n);

        System.out.println("The integer square root of " + n + " is: " + result);
    }

    public static int mySqrt(int x) {
        int l = 0;
        int r = x;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long square = (long) m * m; // avoid overflow

            if (square == x) {
                return m;  // perfect square
            } else if (square < x) {
                l = m + 1; // go right
            } else {
                r = m - 1; // go left
            }
        }

        return r; 
    }
}
