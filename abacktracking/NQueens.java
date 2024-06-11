package abacktracking;

public class NQueens {
    private static boolean isSafe(int[][] board, int row, int col, int N) {
        int i, j;
        
        // Check the left side of the current row
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static boolean solveNQueensUtil(int[][] board, int col, int N) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;

                if (solveNQueensUtil(board, col + 1, N))
                    return true;

                board[i][col] = 0; // Backtrack
            }
        }

        return false;
    }

    public static boolean solveNQueens(int N) {
        int[][] board = new int[N][N];
        
        if (!solveNQueensUtil(board, 0, N)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printBoard(board);
        return true;
    }

    private static void printBoard(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4; //Change N to solve for different board sizes
        solveNQueens(N);
    }
}
