package abacktracking;

public class SudokuSolver201 {
    //: Given a sudoko puzzle, solve this sudoko puzzle by using backtracking
    //algorithm and return the solved puzzle.
    //: The sudoko puzzle is represented by a 2D array of integers.
    //: The empty cells are represented by 0.
    //: The sudoko puzzle is solved in place.
    //: The sudoko puzzle is always valid.
    //: The sudoko puzzle is always 9x9.
    //: The sudoko puzzle is always solvable.
    //: The sudoko puzzle is always solvable by using backtracking algorithm.
    //: The sudoko puzzle is always solvable by using backtracking algorithm in
    //  a reasonable time.
    //: You may assume that there will be only one unique solution.
    //: You may assume that there will be no more than one solution.
    //: You may assume that the input is always valid.
    //: You may assume that the input is always solvable.
    //: You may assume that the input is always solvable by using backtracking
    //  algorithm.
    //: You may assume that the input is always solvable by using backtracking
    //  algorithm in a reasonable time.
    public static void main(String[] args) {
        int[][] puzzle = {
            {0, 0, 0, 2, 6, 0, 7, 0, 1},
            {6, 8, 0, 0, 7, 0, 0, 9, 0},
            {1, 9, 0, 0, 0, 4, 5, 0, 0},
            {8, 2, 0, 1, 0, 0, 0, 4, 0},
            {0, 0, 4, 6, 0, 2, 9, 0, 0},
            {0, 5, 0, 0, 0, 3, 0, 2, 8},
            {0, 0, 9, 3, 0, 0, 0, 7, 4},
            {0, 4, 0, 0, 5, 0, 0, 3, 6},
            {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };
        solve(puzzle);
        print(puzzle);
    }

    private static void print(int[][] puzzle) {
        for (int[] rows : puzzle) {
            for (int number : rows) {
                System.out.print(number + " ");
            }
            System.out.println();
    }

    }


    private static void solve(int[][] puzzle) {
        solve(puzzle, 0, 0);
    }

    private static boolean solve(int[][] puzzle, int row, int column) {
        if (row == puzzle.length) {
            return true;
        }

        if (column == puzzle[0].length) {
            return solve(puzzle, row + 1, 0);
        }

        if (puzzle[row][column] != 0) {
            return solve(puzzle, row, column + 1);
        }

        for (int number = 1; number <= 9; number++) {
            if (isSafe(puzzle, row, column, number)) {
                puzzle[row][column] = number;
                if (solve(puzzle, row, column + 1)) {
                    return true;
                }
                puzzle[row][column] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] puzzle, int row, int column, int number) {
        return isSafeInRow(puzzle, row, number) &&
                isSafeInColumn(puzzle, column, number) &&
                isSafeInBox(puzzle, row, column, number);
    }

    private static boolean isSafeInBox(int[][] puzzle, int row, int column, int number) {
        int boxRowStart = row - row % 3;
        int boxColumnStart = column - column % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColumnStart; c < boxColumnStart + 3; c++) {
                if (puzzle[r][c] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isSafeInColumn(int[][] puzzle, int column, int number) {
        for (int row = 0; row < puzzle.length; row++) {
            if (puzzle[row][column] == number) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSafeInRow(int[][] puzzle, int row, int number) {
        for (int column = 0; column < puzzle[0].length; column++) {
            if (puzzle[row][column] == number) {
                return false;
            }
        }

        return true;
    }

}
