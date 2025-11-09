package Graphs_Problems_6;

import java.util.*;

public class Length_River {

	public static void main(String[] args) {
		//0 is land 1 is water
		int[][] matrix = { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 0 } };

		List<Integer> result = riverSizes(matrix);
		System.out.println(result);

	}
	static int count = 0;
	private static List<Integer> riverSizes(int[][] matrix) {
		int n = matrix.length;
		List<Integer> sizes = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				count = 0;
				if(!visited[i][j] && matrix[i][j] == 1) {
				   dfs(i,j,visited,matrix);
					sizes.add(count);
				}
			}
		}
		return sizes;
	}

	private static void dfs(int i, int j, boolean[][] visited, int[][] matrix) {
		if(i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0) return;
		if(visited[i][j] || matrix[i][j] == 0) return;
		visited[i][j] = true;
		count++;
		dfs(i + 1,j,visited,matrix);
		dfs(i - 1,j,visited,matrix);
		dfs(i,j + 1,visited,matrix);
		dfs(i,j - 1,visited,matrix);
	}

}
