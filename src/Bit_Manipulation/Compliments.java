package Bit_Manipulation;

import java.util.*;

public class Compliments {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String n = sc.next();

        String ones = onesComplement(n);
        String twos = twosComplement(n);

        System.out.println("1's Complement of " + n + ": " + ones);
        System.out.println("2's Complement of " + n + ": " + twos);

        sc.close();
    }

    private static String onesComplement(String n) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n.length(); i++) {

            if (n.charAt(i) == '1')
                result.append('0');
            else
                result.append('1');
        }

        return result.toString();
    }

    private static String twosComplement(String n) {

        String ones = onesComplement(n);

        StringBuilder result = new StringBuilder(ones);

        for (int i = result.length() - 1; i >= 0; i--) {

            if (result.charAt(i) == '0') {
                result.setCharAt(i, '1');
                break;
            }

            result.setCharAt(i, '0');
        }

        return result.toString();
    }
}