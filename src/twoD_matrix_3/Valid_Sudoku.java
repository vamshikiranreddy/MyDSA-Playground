package twoD_matrix_3;

import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board)); // should print true
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];
                if (value == '.') continue;

                if (rows[row].contains(value)) return false;
                rows[row].add(value);

                if (cols[col].contains(value)) return false;
                cols[col].add(value);

                int boxIdx = (row / 3) * 3 + (col / 3);
                if (boxes[boxIdx].contains(value)) return false;
                boxes[boxIdx].add(value);
            }
        }
        return true;
    }
}
