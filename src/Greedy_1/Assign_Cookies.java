package Greedy_1;

import java.util.*;

public class Assign_Cookies {

	public static void main(String[] args) {
		int[] g = { 1, 2, 3 }; // greed factors of children
		int[] s = { 1, 1 }; // sizes of cookies

		int result = findContentChildren(g, s); // method call
		System.out.println("Maximum content children: " + result);
	}

	public static int findContentChildren(int[] greed, int[] size) {
    	int m = greed.length;
    	int n = size.length;
    	Arrays.sort(greed);
    	Arrays.sort(size);
    	int left = 0,right = 0;
    	int count = 0;
    	while(left < n && right <m) {
    		if(size[left] >= greed[right]) {
    			count++;
    			left++;
    			right++;
    		}else {
    			left++;
    		}
    	}
        return count; 
    }
}
