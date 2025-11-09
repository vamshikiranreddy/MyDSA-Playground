package Graphs_Problems;

import java.util.Arrays;

public class Zero_One_FloodFill {

	private static char[][] FloodFill(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		// For First And Last Row
		for (int i = 0; i < n; i++) {
			if (grid[0][i] == 'O' && !visited[0][i])
				dfs(0, i, grid, visited);
			if (grid[m - 1][i] == 'O' && !visited[m - 1][i])
				dfs(m - 1, i, grid, visited);
		}
		// For First And Last Column
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == 'O' && !visited[i][0])
				dfs(i, 0, grid, visited);
			if (grid[i][n - 1] == 'O' && !visited[i][n - 1])
				dfs(i, n - 1, grid, visited);
		}
		
		// Check For inner Sets And Convert
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(grid[i][j] =='O' && !visited[i][j]) {
					grid[i][j] = 'X';
				}
			}
		}
		return grid;
	}

	private static void dfs(int x, int y, char[][] grid, boolean[][] visited) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
		if(grid[x][y] != 'O' ||  visited[x][y]) return;
		visited[x][y] = true;
		dfs(x+1,y,grid,visited);
		dfs(x-1,y,grid,visited);
		dfs(x,y+1,grid,visited);
		dfs(x,y-1,grid,visited);
		
	}

	public static void main(String[] args) {
		char[][] grid = {
			    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'X'},
			    {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X'},
			    {'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X', 'X'},
			    {'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
			    {'X', 'O', 'X', 'X', 'X', 'O', 'O', 'X', 'X', 'X'},
			    {'X', 'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O', 'X'},
			    {'X', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'X', 'O'},
			    {'X', 'X', 'O', 'X', 'O', 'X', 'X', 'O', 'X', 'X'},
			    {'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
			    {'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O', 'O', 'X'}
			};
		System.out.println("The First-Original :- ");
		for (char[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
		FloodFill(grid);
		
		System.out.println("The Grid After FloodFill :");
		for (char[] row : grid) {
			System.out.println(Arrays.toString(row));
		}

	}

}
