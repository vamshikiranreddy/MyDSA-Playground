package Graphs_Problems_6;

import java.util.*;

class Remove_Islands {
	static int[][] removeIslands(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		// First And Last Row
		for (int i = 0; i < n; i++) {
			if (grid[0][i] == 1 && !visited[0][i])
				dfs(0, i, grid, visited);
			if (grid[m - 1][i] == 1 && !visited[m - 1][i])
				dfs(m - 1, i, grid, visited);
		}
		// First And Last column
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == 1 && !visited[i][0])
				dfs(i, 0, grid, visited);
			if (grid[i][n - 1] == 1 && !visited[i][n - 1])
				dfs(i, n - 1, grid, visited);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					grid[i][j] = 0;
				}
			}
		}
		return grid;
	}

	public static void dfs(int r, int c, int[][] grid, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;
		if (r < 0 || r >= m || c < 0 || c >= n)
			return;
		if (visited[r][c] || grid[r][c] == 0)
			return;
		visited[r][c] = true;
		dfs(r + 1, c, grid, visited);
		dfs(r - 1, c, grid, visited);
		dfs(r, c + 1, grid, visited);
		dfs(r, c - 1, grid, visited);
	}

	public static void main(String[] args) {
		int[][] sampleOutput = { { 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 1, 0 }, { 1, 1, 0, 0, 1, 0 },
				{ 1, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1 } };
		System.out.println("Sample Output Array:");
		for (int i = 0; i < sampleOutput.length; i++) {
			System.out.print("[");
			for (int j = 0; j < sampleOutput[i].length; j++) {
				System.out.print(sampleOutput[i][j]);
				if (j < sampleOutput[i].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		int[][] result = removeIslands(sampleOutput);
		System.out.println("OutPut  Array:");
		for (int i = 0; i < result.length; i++) {
			System.out.print("[");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
				if (j < result[i].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
	}
}