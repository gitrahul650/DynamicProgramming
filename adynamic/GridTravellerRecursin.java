package adynamic;

public class GridTravellerRecursin {
    //A robot is situated at top left corner of an m x n grid.
    // It needs to travel to the bottom right corner.
    // The robot can only move either right or down at any point
    //Use recursion to find out how many ways the robot can travel from top left to bottom right

    public static void main(String[] args) {
        int m = 2;
        int n = 2;

        System.out.println("There are " + gridTraveller(m, n) + " ways to travel from top left to bottom right");
    }

    private static long gridTraveller(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
    }

}
