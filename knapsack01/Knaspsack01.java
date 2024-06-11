package a1Dynamic.knapsack01;

public class Knaspsack01 {
    //Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
    //In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
    //respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that
    //sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or
    //don’t pick it (0-1 property).
    //Example: val[] = {60, 100, 120}; wt[] = {10, 20, 30}; W = 50 -> 220
//Approach: Recursion

    public static void main(String[] args) {
//        int[] val = {60, 100, 120};
//        int[] wt = {10, 20, 30};
//        int W = 50;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;
        System.out.println("knapsack01(val, wt, W) = " + knapsack01(val, wt, W));
    }

    public static int knapsack01(int[] val, int[] wt, int W) {
        int n = val.length;
        return knapsack01(val, wt, W, n);
    }

    public static int knapsack01(int[] val, int[] wt, int W, int n) {
        //Base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        //If weight of the nth item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return knapsack01(val, wt, W, n - 1);
        }

        //Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        return Math.max(val[n - 1] + knapsack01(val, wt, W - wt[n - 1], n - 1), knapsack01(val, wt, W, n - 1));
    }

    //Approach: Memoization
    public static int knapsack01Memo(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        return knapsack01Memo(val, wt, W, n, dp);
    }

    public static int knapsack01Memo(int[] val, int[] wt, int W, int n, int[][] dp) {
        //Base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != 0) {
            return dp[n][W];
        }

        //If weight of the nth item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            dp[n][W] = knapsack01Memo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }

        //Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        dp[n][W] = Math.max(val[n - 1] + knapsack01Memo(val, wt, W - wt[n - 1], n - 1, dp),
                knapsack01Memo(val, wt, W, n - 1, dp));
        return dp[n][W];
    }

    //Approach: Dynamic Programming
    public static int knapsack01DP(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        //Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W ; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    //Return the maximum of two cases:
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    //If weight of the nth item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }









}
