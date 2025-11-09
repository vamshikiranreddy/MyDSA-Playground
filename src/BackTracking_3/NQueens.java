package BackTracking_3;

import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		int n = 4;
		List<List<String>> solutions = solveNQueens(n);
		for (List<String> board : solutions) {
			for (String row : board) {
				System.out.println(row);
			}
			System.out.println("------------------------------");
		}

	}
	private static List<String> construct(char[][] board) {
		List<String> Board = new ArrayList<>();
		for(char[] row : board) {
			Board.add(new String(row));
		}
		return Board;
	}

	private static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		char [][] board = new char[n][n];
		for(char [] row : board) Arrays.fill(row, '.');
		recursiveSol(0,n,board,result);
		return result;
	}

	private static void recursiveSol(int col, int n, char[][] board, List<List<String>> result) {
		if(col >= n) {
			result.add(construct(board));
			return;
		}
		for(int row = 0;row<n;row++) {
			if(isSafe(board,row,col,n)) {
				board[row][col] = 'Q';
				recursiveSol(col + 1,n,board,result);
				board[row][col] = '.';
			}
		}
	}
	private static boolean isSafe(char[][] board, int row, int col,int n) {
		//Always Check to The Left Cause it's Already Filled
		int rowRefrence = row;
		int colRefrence = col;
		while(row >= 0 && col >= 0) {
			if(board[row][col] == 'Q') return false;
			row--;
			col--;
		}
		
		row = rowRefrence;
		col = colRefrence;
		while(col >= 0) {
			if(board[row][col] == 'Q') return false;
			col--;
		}
		col = colRefrence;
		while(row < n && col >= 0) {
			if(board[row][col] == 'Q') return false;
			row++;
			col--;
		}
		return true;
	}

	

}
