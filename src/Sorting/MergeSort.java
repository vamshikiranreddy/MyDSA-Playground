package Sorting;

import java.util.Scanner;

public class MergeSort {
	public static int[] mergeSort(int[] array) {
		int n = array.length;
		if(n<=1) return array;
		int middle = n / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[n - middle];
		for (int i = 0; i < middle; i++) {
			leftArray[i] = array[i];
		}
		for (int i = middle; i < n; i++) {
			rightArray[i-middle] = array[i];
		}
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		return merge(leftArray, rightArray,array);
	}

	public static int[] merge(int[] leftArray, int[] rightArray, int[] array) {
		int n = array.length;
		int leftSize = n / 2;
		int rightSize = n - leftSize;
		int[] merged = new int[leftSize + rightSize];
		int i = 0, l = 0, r = 0;
		while (l < leftSize && r < rightSize) {
			if (leftArray[l] < rightArray[r]) {
				merged[i++] = leftArray[l++];
			} else {
				merged[i++] = rightArray[r++];
			}
		}
		while (l < leftSize) {
			merged[i++] = leftArray[l++];
		}
		while (r < rightSize) {
			merged[i++] = rightArray[r++];
		}

		return merged;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size");
		int size = in.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements");
		for (int i = 0; i < array.length; i++) {
			array[i] = in.nextInt();
		}
		System.out.println("Sorted Array :");
		int result[] = mergeSort(array);
		for (int num : result) {
			System.out.print(num+" ");
		}

	}

}
