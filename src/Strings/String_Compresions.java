package Strings;
import java.util.*;
public class String_Compresions {
	private static char [] String_Compression(char[] chars) {
		int n = chars.length;
		char [] result = new char [n*2];
		int index = 0;
		for(int i = 0;i<n;i++) {
			char ch = chars[i];
			int count = 0;
			while(i<n && chars[i] == ch) {
				count++;
				i++;
			}
			if(count == 1) {
				result[index++] = ch;
			}else {
				result[index++] = ch;
				String str = String.valueOf(count);
				for(char c : str.toCharArray()) {
					result[index++] = c;
				}
			}
			i--;
		}
		
		return result;
	}
	public int compress(char[] chars) {
        int i = 0;
        int index = 0;
        while(i < chars.length){
            char current = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == current){
                i++;
                count++;
            }
            chars[index++] = current;
            if(count > 1){
                for(char ch : String.valueOf(count).toCharArray()){
                    chars[index++] = ch;
                }
            }
        }
        return index;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size Of Char Array : ");
		int size = in.nextInt();
		char [] chars = new char[size];
		System.out.println("Enter The Elements  : ");
		for(int i = 0;i<size;i++) {
			chars [i] = in.next().charAt(0);
		}
		char[] result = String_Compression(chars);
		System.out.println("The Array After String Compresion : ");
		for(int i =0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
		in.close();

	}

	

}
