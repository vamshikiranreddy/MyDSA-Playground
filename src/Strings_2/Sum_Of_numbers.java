package Strings_2;
import java.util.*;
public class Sum_Of_numbers {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        int num = 0;
        int sum = 0;
        for(char ch : S.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }else{
                sum += num;
                num = 0;
            }
        }
        sum += num;
        num = 0;
        System.out.println(sum);
        in.close();
    }
}