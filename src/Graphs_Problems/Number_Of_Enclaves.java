package Graphs_Problems;

public class Number_Of_Enclaves {

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        Number_Of_Enclaves obj = new Number_Of_Enclaves();
        int count = obj.numEnclaves(grid);
        System.out.println("Number of Enclave land cells = " + count);
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // Flood fill from all boundary land cells
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0])
                dfs(i, 0, grid, visited);
            if (grid[i][n - 1] == 1 && !visited[i][n - 1])
                dfs(i, n - 1, grid, visited);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j])
                dfs(0, j, grid, visited);
            if (grid[m - 1][j] == 1 && !visited[m - 1][j])
                dfs(m - 1, j, grid, visited);
        }

        // Count remaining unvisited land cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    count++;
            }
        }
        return count;
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n)
            return;
        if (grid[x][y] != 1 || visited[x][y])
            return;

        visited[x][y] = true;

        dfs(x + 1, y, grid, visited);
        dfs(x - 1, y, grid, visited);
        dfs(x, y + 1, grid, visited);
        dfs(x, y - 1, grid, visited);
    }
}
