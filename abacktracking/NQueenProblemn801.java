package abacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblemn801 {
    //find an arrangement of N queens on a chess board, such that no queen can
    //attack any other queens on the board. The chess queens can attack in any direction as
    //horizontal, vertical, horizontal and diagonal way

    public static void main(String[] args) {
        int n = 4;
        System.out.println("solve(n) = " + solve(n));
    }

    private static List<List<Integer>> solve(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(new int[n][n], result, 0);
        return result;
    }

    private static void solve(int[][] board, List<List<Integer>> result, int col) {
        if (col == board.length) {
            List<Integer> list = new ArrayList<>();
            for (int[] ints : board) {
                for (int j = 0; j < board.length; j++) {
                    if (ints[j] == 1) {
                        list.add(j);
                    }
                }
            }
            result.add(list);
        } else {
            for (int i = 0; i < board.length; i++) {
                if (isSafe(board, i, col)) {
                    board[i][col] = 1;
                    solve(board, result, col + 1);
                    board[i][col] = 0;
                }
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        //check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        //check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        //check lower diagonal on left side
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
