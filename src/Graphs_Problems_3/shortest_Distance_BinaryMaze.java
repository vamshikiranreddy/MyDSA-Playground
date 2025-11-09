package Graphs_Problems_3;

import java.util.*;

public class shortest_Distance_BinaryMaze {

    // Tuple to store row, col, and distance
    static class Tuple {
        int row, col, dist;
        Tuple(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };

        int result = Shortest(grid);
        System.out.println("The Shortest Distance from Topleft to Bottom Right is: " + result);
    }

    public static int Shortest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // If start or end is blocked
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        // BFS setup
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, 0, 1));
        grid[0][0] = 1; // mark visited

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, -1}, {-1, 1}, {1, 1}, {-1, -1}
        };

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();

            // Reached destination
            if (current.row == m - 1 && current.col == n - 1) {
                return current.dist;
            }

            // Explore all 8 directions
            for (int[] dir : directions) {
                int nx = current.row + dir[0];
                int ny = current.col + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1; // mark visited
                    queue.offer(new Tuple(nx, ny, current.dist + 1));
                }
            }
        }

        return -1; // No path found
    }
}
