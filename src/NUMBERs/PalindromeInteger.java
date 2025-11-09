package NUMBERs;
import java.util.*;
public class PalindromeInteger {
	public static void main(String[]args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter The Integer: ");
	int numb = in.nextInt();
	// string builder 
	/*
	String num = Integer.toString(numb);
	StringBuilder sb = new StringBuilder(num);
	String rev_num = sb.reverse().toString();
	if(rev_num.equals(num)) {
		System.out.println("YES");
	}else {
		System.out.println("NO");
	}
	*/
	// Arithmetic 
	int original = numb;
	int reverse = 0;
	while(numb>0){
		int digit = numb%10;
		reverse = reverse*10 + digit;
		numb = numb/10;
	}
	if(reverse==original) {
		System.out.println("YES");
	}else {
		System.out.println("NO");
	}
	in.close();
  }

}
