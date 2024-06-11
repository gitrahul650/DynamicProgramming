package a1Dynamic.unboundedKnapsack;

public class RodCuttingProblemn01 {
    //Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
    // Determine the maximum value obtainable by cutting up the rod and selling the pieces.
    //Example: length[] = {1, 2, 3, 4, 5, 6, 7, 8}; price[] = {1, 5, 8, 9, 10, 17, 17, 20}; n = 8 -> 22

    //Approach: Dynamic Programming

    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println("rodCuttingProblem(length, price, n) = " + rodCuttingProblem(length, price, n));
    }

    public static int rodCuttingProblem(int[] length, int[] price, int n) {
        int[][] dp = new int[length.length + 1][n + 1];

        // If length is 0, then answer is 0
        for (int i = 0; i <= length.length; i++) {
            dp[i][0] = 0;
        }

        // If length is not 0 and price is 0, then answer is 0
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        // Fill the subset table in bottom up manner
        for (int i = 1; i <= length.length; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j < length[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //Excluding the current element
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                }
            }
        }

        return dp[length.length][n];
    }
}
