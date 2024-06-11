package abacktracking;

public class SudokuSolve {
    //Given a 9x9 sudoku board, find a solution to the sudoku.
    //Example: Input: board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},     Output: {{3, 1, 6, 5, 7, 8, 4, 9, 2},
    //                         {5, 2, 0, 0, 0, 0, 0, 0, 0},              {5, 2, 9, 1, 3, 4, 7, 6, 8},
    //                         {0, 8, 7, 0, 0, 0, 0, 3, 1},              {4, 8, 7, 6, 2, 9, 5, 3, 1},
    //                         {0, 0, 3, 0, 1, 0, 0, 8, 0},              {2, 6, 3, 4, 1, 5, 9, 8, 7},
    //                         {9, 0, 0, 8, 6, 3, 0, 0, 5},              {9, 7, 1, 8, 6, 3, 2, 4, 5},
    //                         {0, 5, 0, 0, 9, 0, 6, 0, 0},              {6, 5, 8, 7, 9, 2, 1, 4, 3},
    //                         {8, 0, 0, 0, 0, 0, 0, 0, 0},              {8, 3, 4, 5, 2, 6, 9, 1, 7},
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 6},              {7, 9, 6, 3, 4, 1, 8, 2, 5},
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 0},              {1, 2, 5, 9, 8, 7, 6, 3, 4},
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 0},              {3, 4, 9, 2, 5, 6, 7, 8, 1},
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 0},              {2, 1, 7, 4, 3, 8, 5, 9, 6},
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 0},              {5, 6, 1, 7, 9, 2, 3, 4, 8},
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 0},              {4, 3, 2, 6, 1, 5, 8, 7, 9}}
    //                         {0, 0, 0, 0, 0, 0, 0, 0, 0}};             {7, 8, 9, 3, 4, 2, 6, 5, 1}};
    //Constraints: board.length == 9, board[i].length == 9, 0 <= board[i][j] <= 9

    public static void main(String[] args) {
        int[][] board = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solveSudoku(board,0,0);
        printBoard(board);



}

    private static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++){
            if(i % 3 == 0){
                System.out.println("-------------------------");
            }
            for(int j = 0; j < board[i].length; j++){
                if(j % 3 == 0){
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }


    private static boolean solveSudoku(int[][] board, int row, int col){
        if(row == board.length && ++col == board[row].length){
            return true;
        }
        if(row == board.length){
            row = 0;
        }
        if(board[row][col] != 0){
            return solveSudoku(board, row + 1, col);
        }
        for(int val = 1; val <= 9; val++){
            if(isValid(board, row, col, val)){
                board[row][col] = val;
                if(solveSudoku(board, row + 1, col)){
                    return true;
                }
            }
        }
        board[row][col] = 0;
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int val){
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == val || board[i][col] == val){
                return false;
            }
        }
        int subRow = (row / 3) * 3;
        int subCol = (col / 3) * 3;
        for(int i = subRow; i < subRow + 3; i++){
            for(int j = subCol; j < subCol + 3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
    }
