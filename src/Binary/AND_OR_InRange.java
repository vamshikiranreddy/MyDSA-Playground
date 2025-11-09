package Binary;

import java.util.Scanner;

public class AND_OR_InRange {

    // Function to find Bitwise AND in range [left, right] using shift operations
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        
        // Keep shifting right until both numbers are the same
        while (left < right) {
            left >>= 1;  // Right shift left
            right >>= 1; // Right shift right
            shift++;     // Count shifts
        }
        
        // Shift back to get the final AND result
        return left << shift; // Left shift back
    }

    // Function to find Bitwise OR in range [left, right] using shift operations
    public static int rangeBitwiseOr(int left, int right) {
        int shift = 0;
        
        // Keep shifting right until left and right become different
        while ((left | (left + 1)) <= right) {
            left |= (left + 1); // Set rightmost 0-bit to 1
            shift++;
        }
        
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input from user
        System.out.print("Enter the value of left: ");
        int left = sc.nextInt();
        
        System.out.print("Enter the value of right: ");
        int right = sc.nextInt();
        
        // Compute AND and OR results
        int andResult = rangeBitwiseAnd(left, right);
        int orResult = rangeBitwiseOr(left, right);
        
        // Print results
        System.out.println("Bitwise AND result: " + andResult);
        System.out.println("Bitwise OR result: " + orResult);
        
        sc.close(); // Close scanner
    }
}
