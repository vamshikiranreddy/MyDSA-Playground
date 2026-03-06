package Regex;

import java.util.regex.*;

public class Password_Validation {

	public static void main(String[] args) {
		String password = "gftdrstr8645";
		System.out.println("The password of the customer is " + password);
		if (isValidPassword(password))
			System.out.println("The password is valid!");
		else
			System.out.println("The password is not valid!");
	}

	private static boolean isValidPassword(String password) {
		String regex = "[a-zA-Z]{8,10}[0-9]{4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

}