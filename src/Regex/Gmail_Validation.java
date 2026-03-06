package Regex;

import java.util.regex.*;

public class Gmail_Validation {

	public static void main(String[] args) {
		String email = "steve123@gmail.com";
		System.out.println("The Email Id of the customer is " + email);
		if (isValidEmail_1(email) && isValidEmail_2(email))
			System.out.println("The Email Id is valid!");
		else
			System.out.println("The Email Id is invalid!");
	}

	private static boolean isValidEmail_2(String email) {
		return email.matches("^[a-zA-Z0-9]+@[a-zA-Z]+\\.(com|in)$");
	}

	private static boolean isValidEmail_1(String email) {
		String regex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.(com|in)$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.matches();
	}

}
