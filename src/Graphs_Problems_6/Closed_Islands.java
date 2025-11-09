package Graphs_Problems_6;

public class Closed_Islands {

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Flood-fill border lands (not closed)
        for (int i = 0; i < n; i++) {
            dfs(0, i, grid);
            dfs(m - 1, i, grid);
        }
        for (int j = 0; j < m; j++) {
            dfs(j, 0, grid);
            dfs(j, n - 1, grid);
        }

        // Step 2: Count closed islands
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) {
            return;
        }

        grid[r][c] = 1; // mark visited
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }

    // --- Testing ---
    public static void main(String[] args) {
        Closed_Islands solver = new Closed_Islands();

        int[][] grid = {
            {1,1,1,1,1,1,1,0},
            {1,0,0,0,0,1,1,0},
            {1,0,1,0,1,1,1,0},
            {1,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,0}
        };

        System.out.println("Number of Closed Islands: " + solver.closedIsland(grid));
    }
}
