package BackTracking;

import java.util.*;

public class Binary_Strings_Without_Adjacent_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the string: ");
        int n = in.nextInt();
        in.close();

        System.out.println("Binary strings without consecutive 1s:");
        generateNoConsecutiveOnes(n, new StringBuilder(), ' ');

        System.out.println("\nBinary strings without consecutive 0s:");
        generateNoConsecutiveZeros(n, new StringBuilder(), ' ');
    }

    // Method 1: No consecutive 1s
    private static void generateNoConsecutiveOnes(int n, StringBuilder sb, char lastChar) {
        if (sb.length() == n) {
            System.out.println(sb.toString());
            return;
        }

        // Always can add '0'
        sb.append('0');
        generateNoConsecutiveOnes(n, sb, '0');
        sb.deleteCharAt(sb.length() - 1);

        // Add '1' only if last char is not '1'
        if (lastChar != '1') {
            sb.append('1');
            generateNoConsecutiveOnes(n, sb, '1');
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Method 2: No consecutive 0s
    private static void generateNoConsecutiveZeros(int n, StringBuilder sb, char lastChar) {
        if (sb.length() == n) {
            System.out.println(sb.toString());
            return;
        }

        // Always can add '1'
        sb.append('1');
        generateNoConsecutiveZeros(n, sb, '1');
        sb.deleteCharAt(sb.length() - 1);

        // Add '0' only if last char is not '0'
        if (lastChar != '0') {
            sb.append('0');
            generateNoConsecutiveZeros(n, sb, '0');
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
