package adynamic;

public class GridTravellerTabulation {
    //A robot is situated at top left corner of an m x n grid.
    // It needs to travel to the bottom right corner.
    // The robot can only move either right or down at any point
    //Use tabulation to find out how many ways the robot can travel from top left to bottom right

    public static void main(String[] args) {
        int m = 18;
        int n = 18;

        System.out.println("There are " + gridTraveller(m, n) + " ways to travel from top left to bottom right");
    }

    private static long gridTraveller(int m, int n) {
        long[][] table = new long[m + 1][n + 1];

        table[1][1] = 1;

        for (int row = 0; row <= m; row++) {
            for (int col = 0; col <= n; col++) {
                long current = table[row][col];

                if (row + 1 <= m) {
                    table[row + 1][col] += current;
                }

                if (col + 1 <= n) {
                    table[row][col + 1] += current;
                }
            }
        }

        return table[m][n];
    }
}
