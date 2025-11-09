package Sorting;
import java.util.*;
public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // Create empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Put array elements in different buckets
        for (float num : arr) {
            int index = (int) (num * n); // Bucket index
            buckets[index].add(num);
        }

        // Sort individual buckets
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate all sorted buckets
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of elements
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        float[] arr = new float[n];

        // Input: elements of the array
        System.out.println("Enter " + n + " floating-point numbers between 0 and 1:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextFloat();
        }

        // Sorting
        bucketSort(arr);

        // Output sorted array
        System.out.println("Sorted array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
