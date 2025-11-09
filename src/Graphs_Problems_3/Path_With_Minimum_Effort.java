package Graphs_Problems_3;

import java.util.*;

public class Path_With_Minimum_Effort {

    static class Truple {
        int row, col, effort;
        Truple(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] minEffort = new int[m][n];
        for (int[] row : minEffort)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Truple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        pq.offer(new Truple(0, 0, 0));
        minEffort[0][0] = 0;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            Truple curr = pq.poll();
            int x = curr.row;
            int y = curr.col;
            int effort = curr.effort;

            if (x == m - 1 && y == n - 1) return effort;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (nextEffort < minEffort[nx][ny]) {
                        minEffort[nx][ny] = nextEffort;
                        pq.offer(new Truple(nx, ny, nextEffort));
                    }
                }
            }
        }
        return 0;
    }

    // quick test
    public static void main(String[] args) {
        Path_With_Minimum_Effort solver = new Path_With_Minimum_Effort();
        int[][] heights = {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        System.out.println(solver.minimumEffortPath(heights)); // Expected output: 2
    }
}
