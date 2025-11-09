package Strings;
import java.util.*;
public class Pattren_Matching {
	    public static void Search(String text,String pat){
	        int pat_len = pat.length();
	        int text_len = text.length();
	        for(int i = 0;i<= text_len-pat_len;i++){
	            if(text.substring(i,i+pat_len).equals(pat)){
	                System.out.println("Pattern found at index " + i);
	            }
	        }
	    }
	    public static void main(String[]args){
	        Scanner in = new Scanner(System.in);
	        System.out.println("Enter The Text: ");
	        String text =in.nextLine();
	        System.out.println("Enter The Pattren: ");
	        String pat = in.nextLine();
	        Search(text,pat);
	        in.close();
	    }
	}

