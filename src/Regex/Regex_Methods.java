package Regex;

import java.util.regex.*;
import java.util.*;

public class Regex_Methods {
    static class RegexClass {
        RegexClass() {

        }

        // Checks Weather the whole String has a pattern
        public void Matches() {
            String PhoneNumber = "9108257153";
            if (PhoneNumber.matches("\\d{10}")) {
                System.out.println("Valid Phone Number !!!");
            } else {
                System.out.println("Invalid PhoneNumber");
            }
            String name = "Vamshi";
            if (name.matches("[a-zA-Z]+")) {
                System.out.println("Valid Name");
            } else {
                System.out.println("Invalid Name");
            }
        }

        // Checks weather there is a pattern in a string
        public void Find() {
            System.out.println("The Find Method");
            String text = "Order Number is 1223445";

            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(text);

            if (m.find()) {
                System.out.println("Pattern Found");
            }

            // Group
            System.out.println("The Group Method");

            Pattern p1 = Pattern.compile("12234");
            Matcher m1 = p1.matcher(text);

            if (m1.find()) {
                System.out.println(m1.group());
            }

            String str = "abcabdabdcabeabcd";

            Pattern p2 = Pattern.compile("(abc)+");
            Matcher m2 = p2.matcher(str);
            int count = 0;
            while (m2.find()) {
                count++;
            }

            if (m2.find()) {
                System.out.println("The Number Of Times The Pattern Has Appeared : " + count);
                System.out.println("The Pattern:" + m2.group());
            }

            // Start And End

            Pattern p3 = Pattern.compile("\\d+");
            Matcher m3 = p3.matcher(text);

            if (m3.find()) {
                System.out.println("The Start Idx Of The Pattern in String : " + m3.start());
                System.out.println("The End Idx Of The Pattern in String : " + m3.end());
            }
        }

        public void Replace_All() {
            System.out.println("The Find Method");
            String text = "Order Number is 1223445";
            String res1 = text.replaceAll("\\\\s+", "");
            String res2 = text.replace("2", "9");
            System.out.println("Using ReplaceAll : " + res1);
            System.out.println("Using Replace : " + res2);
        }

        public void Split() {
            String text = "Order Number is 1223445";
            String[] s = text.split("\\\\s");
            List<String> S = new ArrayList<>(Arrays.asList(s));
            System.out.println("Split Function: " + S);
        }
    }

    public static void main(String[] args) {
        RegexClass regex = new RegexClass();
        regex.Matches();
        regex.Find();
        regex.Replace_All();
        regex.Split();
    }
}