package Graphs_Problems;

public class Number_Of_Islands {

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands (Union-Find): " + numIslands_UF(grid));

        // Deep copy of grid for DFS version
        char[][] gridDFS = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            gridDFS[i] = grid[i].clone();
        }
        System.out.println("Number of Islands (DFS): " + numIslands_DFS(gridDFS));
    }

    // ---------- Union-Find Approach ----------
    public static int numIslands_UF(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        UnionFind uf = new UnionFind(grid);
        int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == '1') {
                            int id1 = i * cols + j;
                            int id2 = ni * cols + nj;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int size = rows * cols;

            parent = new int[size];
            rank = new int[size];
            count = 0;

            for (int i = 0; i < size; i++) {
                int row = i / cols;
                int col = i % cols;
                if (grid[row][col] == '1') {
                    parent[i] = i;
                    count++;
                } else {
                    parent[i] = -1;
                }
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == -1 || rootV == -1 || rootU == rootV) return;

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            count--;
        }

        int getCount() {
            return count;
        }
    }

    // ---------- DFS Approach ----------
    public static int numIslands_DFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';  // mark as visited

        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
}
