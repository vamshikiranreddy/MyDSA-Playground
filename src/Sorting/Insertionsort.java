package Sorting;

import java.util.Scanner;

public class Insertionsort{
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		   System.out.println("Enter the size");	
		   int size = in.nextInt();
		   int [] array = new int[size];
		   System.out.println("Enter the elements");
		   for(int i = 0;i<array.length;i++) {
			   array[i]=in.nextInt();
	          }
		   insertionsort(array);
		   for(int i: array) {
			   System.out.print(i+" ");
		   }
		   in.close();
		 }
	public static void insertionsort(int [] array) {
		for(int i=1;i<array.length;i++) {
			int temp = array[i];
			int j = i-1;
			while(j>=0 && array[j]>temp){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
		
	}
}
	
		
		

