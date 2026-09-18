package Bit_Manipulation;

import java.util.*;

public class Decimal_To_Binary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();

        // Method 1: Manual conversion
        String result1 = decimalToBinary(n);
        System.out.println("Manual Method: " + result1);

        // Method 2: Built-in Java method
        String result2 = decimalToBinaryBuiltIn(n);
        System.out.println("Built-in Method: " + result2);

        sc.close();
    }

    // Method 1: Using division by 2
    private static String decimalToBinary(int num) {

        if (num == 0)
            return "0";

        StringBuilder result = new StringBuilder();

        while (num != 0) {
            result.append(num % 2);
            num /= 2;
        }

        return result.reverse().toString();
    }

    // Method 2: Using Java's built-in function
    private static String decimalToBinaryBuiltIn(int num) {

        return Integer.toBinaryString(num);
    }
}