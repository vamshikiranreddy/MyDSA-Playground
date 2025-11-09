package Greedy_1;

public class Valid_Paranthesis_String {

    public static boolean checkValidString(String s) {
        int minOpen = 0; // minimum possible open brackets
        int maxOpen = 0; // maximum possible open brackets

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // '*'
                minOpen--;   // if '*' acts as ')'
                maxOpen++;   // if '*' acts as '('
            }

            if (maxOpen < 0) return false; // too many ')'
            if (minOpen < 0) minOpen = 0; // can't go below 0
        }

        return minOpen == 0;
    }

    public static void main(String[] args) {
        String test1 = "(*))";    // true
        String test2 = "(*()";    // true
        String test3 = "(*)))";   // false

        System.out.println(test1 + " -> " + checkValidString(test1));
        System.out.println(test2 + " -> " + checkValidString(test2));
        System.out.println(test3 + " -> " + checkValidString(test3));
    }
}
