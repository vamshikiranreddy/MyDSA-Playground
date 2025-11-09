package Graphs_Problems;

import java.util.*;

public class Number_Of_Distinct_Island {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };

		int count = countDistinctIslands(grid);
		System.out.println("Number of Distinct Islands: " + count);
	}

	private static int countDistinctIslands(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for (boolean[] row : visited)
			Arrays.fill(row, false);
		Set<String> shapes = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					List<String> shape = new ArrayList<>();
					dfs(i,j,grid,visited,shape,i,j);
					shapes.add(String.join(";", shape));
				}
			}
		}
		return shapes.size();
	}

	private static void dfs(int row, int column, int[][] grid, boolean[][] visited, List<String> shape, int baseRow, int baseColumn) {
		int m = grid.length;
		int n = grid[0].length;
		if(row < 0 || row >= m || column < 0 || column >= n || visited[row][column] || grid[row][column] == 0) return;
		visited[row][column] = true;
		shape.add((row - baseRow) + "," + (column - baseColumn));
		
		dfs(row+1,column,grid,visited,shape,baseRow,baseColumn);
		dfs(row,column+1,grid,visited,shape,baseRow,baseColumn);
		dfs(row-1,column,grid,visited,shape,baseRow,baseColumn);
		dfs(row,column-1,grid,visited,shape,baseRow,baseColumn);
		
		
	}

}
