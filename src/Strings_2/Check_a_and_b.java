package Strings_2;

import java.util.Scanner;

public class Check_a_and_b {
    public static int repeatedStringMatch(String A, String B) {
        StringBuilder repeatedA = new StringBuilder(A);
        int count = 1; // Initial repetition count

        // Repeat A until its length is at least the length of B
        while (repeatedA.length() < B.length()) {
            repeatedA.append(A);
            count++;
        }

        // Check if B is in repeated A
        if (repeatedA.toString().contains(B)) {
            return count;
        }

        // Append A one more time and check again
        repeatedA.append(A);
        count++;

        if (repeatedA.toString().contains(B)) {
            return count;
        }

        return -1; // B is not a substring of A even after repetitions
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for A and B
        System.out.print("Enter string A: ");
        String A = scanner.nextLine();

        System.out.print("Enter string B: ");
        String B = scanner.nextLine();

        // Calling function and printing result
        int result = repeatedStringMatch(A, B);
        System.out.println("Minimum repetitions required: " + result);

        scanner.close();
    }
}
