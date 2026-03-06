package Regex;

import java.util.regex.*;

public class WebbAddress_Validation {
	public static boolean checkWebAddressValidity_One(String webAddress) {
		String regex = "^https?:\\/\\/(www\\.)?[a-zA-Z0-9]+\\.(com|org|net)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(webAddress);
		return m.matches();
	}

	public static void main(String[] args) {
		String webAddress = "http://www.company.com";
		System.out.println("The WebAddress is " + (checkWebAddressValidity_Two(webAddress) ? "valid!" : "invalid!"));
		System.out.println("The web address is " + (checkWebAddressValidity_One(webAddress) ? "valid!" : "invalid!"));
	}

	private static boolean checkWebAddressValidity_Two(String webAddress) {
		return webAddress.matches("^https?:\\/\\/(www\\.)?[a-zA-Z0-9]+\\.(com|org|net)$");
	}

}
