package Graphs_Problems;

import java.util.*;

public class Zero_One {

	static class Pair {
		int row;
		int column;

		Pair(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	public static int[][] updateMatrix(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dist = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		for (int[] dis : dist)
			Arrays.fill(dis, 0);
		for (boolean[] vis : visited)
			Arrays.fill(vis, false);
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					visited[i][j] = true;
					queue.offer(new Pair(i, j));
				}
			}
		}
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!queue.isEmpty()) {
			int x = queue.peek().row;
			int y = queue.peek().column;
			queue.poll();
			for (int[] direction : directions) {
				int nx = x + direction[0];
				int ny = y + direction[1];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
					dist[nx][ny] = dist[x][y] + 1;
					visited[nx][ny] = true;
					queue.offer(new Pair(nx, ny));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };

		int[][] result = updateMatrix(grid);

		System.out.println("Distance to nearest 1 for each cell:");
		for (int[] row : result) {
			System.out.println(Arrays.toString(row));
		}
	}
}
