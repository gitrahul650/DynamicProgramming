package adynamic;

public class GridTravellerMemoization {
    //A robot is situated at top left corner of an m x n grid.
    // It needs to travel to the bottom right corner.
    // The robot can only move either right or down at any point
    //Use memoization to find out how many ways the robot can travel from top left to bottom right

    public static void main(String[] args) {
        int m = 18;
        int n = 18;
        long[][] memo = new long[m + 1][n + 1];
        System.out.println("There are " + gridTraveller(m, n, memo) + " ways to travel from top left to bottom right");
    }

    private static long gridTraveller(int m, int n, long[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        memo[m][n] = gridTraveller(m - 1, n, memo) + gridTraveller(m, n - 1, memo);
        return memo[m][n];
    }
}
