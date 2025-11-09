package Sorting;
import java.util.*;
public class Bubblesort {
	
	public static void main(String[]args) {
	   Scanner in = new Scanner(System.in);
	   System.out.println("Enter the size");	
	   int size = in.nextInt();
	   int [] array = new int[size];
	   System.out.println("Enter the elements");
	   for(int i = 0;i<array.length;i++) {
		   array[i]=in.nextInt();
	   }
	   /*bubblesort(array);
	   int [] result = Arrays.stream(array).distinct().toArray();
	   */
	   for(int i:array) {
		   System.out.print(i+" ");
	   }
	   in.close();
	
	}
	
	public static void bubblesort(int []array) {
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					int temp =array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
	}

}
