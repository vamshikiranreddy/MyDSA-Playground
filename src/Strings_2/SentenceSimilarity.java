package Strings_2;
import java.util.*;
public class SentenceSimilarity {
	public static boolean areSimilar(String sentence1,String sentence2) {
		String arr1[] = sentence1.split(" ");
		String arr2[] = sentence2.split(" ");
		int start = 0,
				end1 = arr1.length-1,
				end2 = arr2.length-1;
		if(arr1.length>arr2.length) {
			return areSimilar(sentence2,sentence1);
		}
		while(start<arr1.length && arr1[start].equals(arr2[start])){
			start++;
		}
		while(end1 >= 0 && arr1[end1].equals(arr2[end2])){
			end1 --;
			end2 --;
		}
		return start>end1;
	}
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The First Sentence:");
		String sentence1 = in.nextLine();
		System.out.println("Enter The Second Sentence:");
		String sentence2 = in.nextLine();
		boolean result = areSimilar(sentence1,sentence2);
		if(result){
			System.out.println("TRUE!!!!!!!!!!!");
		}else {
			System.out.println("FALSE!!!!!!!!!!");
		}
	}

}
