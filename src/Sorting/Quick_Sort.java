package Sorting;

import java.util.*;

public class Quick_Sort {

	public static void QuickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pivotidx = Partion(arr,low,high);
			
			QuickSort(arr,0,pivotidx-1); // Sort The Left Of The Pivot
			QuickSort(arr,pivotidx+1,high); // Sort The Right Of The Pivot
		}

	}

	public static int Partion(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		for(int j = low;j<high;j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		// Now Swap The Pivot With The Greatest element
		i++;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		return i;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size :-");
		int size = in.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter The Elements :-");
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println("The Array Before Soritng -");
		Print(arr);
		QuickSort(arr,0,arr.length-1);
		System.out.println("The Array after Sorting -");
		Print(arr);
		in.close();
	}

	private static void Print(int[] arr) {
		if (arr.length < 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
