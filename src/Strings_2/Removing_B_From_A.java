package Strings_2;

public class Removing_B_From_A {
    
    // ✅ Method 1: Using Regex (Character Removal)
    public static String removeCharactersRegex(String a, String b) {
        String regex = "[" + b + "]";  // Create regex pattern to match any character in 'b'
        return a.replaceAll(regex, "");  // Remove characters
    }

    // ✅ Method 2: Removing Substring (Using replaceFirst in a Loop)
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");  // Remove first occurrence of 'part'
        }
        return s;
    }

    public static void main(String[] args) {
        // Example 1: Remove Characters using Regex
        String a = "hello world";
        String b = "lo";  
        System.out.println("Regex Output: " + removeCharactersRegex(a, b));  // Output: "he wrd"

        // Example 2: Remove Substring Using Loop
        String s = "axxxxyyyyb";
        String part = "xy";
        System.out.println("Loop Output: " + removeOccurrences(s, part));  // Output: "ab"
    }
}
