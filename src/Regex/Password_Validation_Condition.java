package Regex;

import java.util.regex.*;

public class Password_Validation_Condition {
	// Atleast one UpperCase
	// AtLeast one LowerCase
	// AtleastOne Digit

	public static void main(String[] args) {
		String password = "Gftdrstr8645";
		System.out.println("The password of the customer is " + password);
		if (isValidPassword(password))
			System.out.println("The password is valid!");
		else
			System.out.println("The password is not valid!");
	}

	private static boolean isValidPassword(String password) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

}