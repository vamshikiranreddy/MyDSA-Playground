package Regex;

public class Valid_PhoneNumber {

    public static void main(String[] args) {
        String PhoneNumber = "9108257153";
        if (PhoneNumber.matches("\\d{10}")) {
            System.out.println("Valid PhoneNumber!!!!!!");
        } else {
            System.out.println("Not Valid :(");
        }
    }

}