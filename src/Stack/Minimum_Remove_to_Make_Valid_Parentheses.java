package Stack;

import java.util.Scanner;

public class Minimum_Remove_to_Make_Valid_Parentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with parentheses: ");
        String input = sc.nextLine();

        String result = minRemoveToMakeValid(input);
        System.out.println("Valid parentheses string: " + result);

        sc.close();
    }

    public static String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int count = 0;

        // First pass: remove unmatched ')'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                count++;
            } else if (arr[i] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    arr[i] = '0'; // mark invalid ')'
                }
            }
        }

        // Second pass: remove unmatched '('
        count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ')') {
                count++;
            } else if (arr[i] == '(') {
                if (count > 0) {
                    count--;
                } else {
                    arr[i] = '0'; // mark invalid '('
                }
            }
        }

        // Build the final result
        StringBuilder result = new StringBuilder();
        for (char ch : arr) {
            if (ch != '0') {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
