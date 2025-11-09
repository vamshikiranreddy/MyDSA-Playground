package Graphs_Problems;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class rotten_Oranges {

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Initialize queue with rotten oranges and count fresh
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int minutes = 0;

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int x = current.row;
                int y = current.column;

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < rows && ny < columns && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new Pair(nx, ny));
                        freshOranges--;
                        rotten = true;
                    }
                }
            }

            if (rotten) minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = orangesRotting(grid);
        System.out.println("Minutes to rot all oranges: " + result);
    }
}
