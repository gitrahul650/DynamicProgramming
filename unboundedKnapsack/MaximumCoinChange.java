package a1Dynamic.unboundedKnapsack;

public class MaximumCoinChange {
    //Given a value N, if we want to make change for N cents, and we have infinite supply of each of
    // S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
    //Example: N = 4; S = {1, 2, 3} -> 4
    //1 + 1 + 1 + 1     1 + 1 + 2     2 + 2     1 + 3

    //Approach: Dynamic Programming

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int n = 4;
        System.out.println("maximumCoinChange(coins, n) = " + maximumCoinChange(coins, n));
    }

    public static int maximumCoinChange(int[] coins, int n) {
        int[][] dp = new int[coins.length + 1][n + 1];

        // If n is 0, then answer is 1
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        // If n is not 0 and coins is 0, then answer is 0
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        // Fill the subset table in bottom up manner
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //Excluding the current element
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][n];
    }
}
