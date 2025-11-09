package Graphs_6_list;

import java.util.Arrays;

public class Flood_FIll {

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        System.out.println("Original Image:");
        printImage(image);

        floodFill(image, sr, sc, newColor);

        System.out.println("\nAfter Flood Fill:");
        printImage(image);
    }

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // Avoid infinite loop
        if (originalColor == newColor) return;

        dfs(image, sr, sc, originalColor, newColor);
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary Check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;

        // Only fill same color
        if (image[r][c] != originalColor) return;

        image[r][c] = newColor;

        // Move in 4 directions
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r, c + 1, originalColor, newColor); // Right
        dfs(image, r, c - 1, originalColor, newColor); // Left
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
