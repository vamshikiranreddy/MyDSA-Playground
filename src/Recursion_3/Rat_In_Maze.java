package Recursion_3;

import java.util.*;

public class Rat_In_Maze {

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		List<String> result = ratInMaze(maze);

		for (String p : result) {
			System.out.print(p + " ");
		}
	}

	private static List<String> ratInMaze(int[][] maze) {
		int m = maze.length;
		int n = maze[0].length;
		List<String> result = new ArrayList<>();
		boolean[][] visited = new boolean[m][n];
		StringBuilder sb = new StringBuilder();
		recursiveDFS(0, 0, sb, maze, visited, result, m, n);
		return result;
	}

	private static void recursiveDFS(int row, int col, StringBuilder sb, int[][] maze, boolean[][] visited,
			List<String> result, int m, int n) {
		if (row == m - 1 && col == n - 1) {
			result.add(sb.toString());
			return;
		}
		visited[row][col] = true;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		String[] dir = { "D", "U", "R", "L" };
		for (int i = 0; i < directions.length; i++) {
			int nr = row + directions[i][0];
			int nc = col + directions[i][1];
			if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && maze[nr][nc] == 1) {
				sb.append(dir[i]);
				recursiveDFS(nr, nc, sb, maze, visited, result, m, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		visited[row][col] = false;
	}
}
