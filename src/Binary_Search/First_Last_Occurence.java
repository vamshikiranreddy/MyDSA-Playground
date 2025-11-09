package Binary_Search;

import java.util.Scanner;

public class First_Last_Occurence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter The Size Of Array");
        int size = in.nextInt();

        System.out.println("Enter The Elements");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }

        System.out.println("Enter The Target : ");
        int target = in.nextInt();

        int[] index = Binary_Search(array, target);

        System.out.println("The First Occurrence Of Element " + target + " was at Index : " + index[0]);
        System.out.println("The Last Occurrence Of Element " + target + " was at Index : " + index[1]);

        in.close();
    }

    private static int[] Binary_Search(int[] array, int target) {
        int first = findFirst(array, target);
        int last = findLast(array, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                idx = mid;
                high = mid - 1; // search left
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }

    private static int findLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                idx = mid;
                low = mid + 1; // search right
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }
}
