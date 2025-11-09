package Graphs_Problems_3;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if first char matches
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int r, int c, int index, String word) {
        if (index == word.length()) return true;

        // Bounds and conditions
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (visited[r][c] || board[r][c] != word.charAt(index)) return false;

        // Mark visited
        visited[r][c] = true;

        // Explore 4 directions
        boolean found = dfs(board, visited, r + 1, c, index + 1, word) ||
                        dfs(board, visited, r - 1, c, index + 1, word) ||
                        dfs(board, visited, r, c + 1, index + 1, word) ||
                        dfs(board, visited, r, c - 1, index + 1, word);

        // Backtrack (unmark visited for other paths)
        visited[r][c] = false;

        return found;
    }

    // For quick test
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCEDA";
        System.out.println(ws.exist(board, word)); // true
    }
}
