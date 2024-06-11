package a1Dynamic.unboundedKnapsack;

public class unboundedKnapsack {
    //Given a knapsack weight W and a set of n items with certain value vali and weight wti,
    // we need to calculate the maximum amount that could make up this quantity exactly.
    // This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
    //Example: W = 100; val[] = {10, 30, 20}; wt[] = {5, 10, 15} -> 300
    //Approach: Recursion

    public static void main(String[] args) {
        int[] val = {10, 30, 20};
        int[] wt = {5, 10, 15};
        int W = 100;
        System.out.println("unboundedKnapsack(val, wt, W) = " + unboundedKnapsack(val, wt, W));
    }

    public static int unboundedKnapsack(int[] val, int[] wt, int W) {
        int n = val.length;
        return unboundedKnapsack(val, wt, W, n);
    }

    public static int unboundedKnapsack(int[] val, int[] wt, int W, int n) {
        //Base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        //If weight of the nth item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            return unboundedKnapsack(val, wt, W, n - 1);
        }

        //Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        return Math.max(val[n - 1] + unboundedKnapsack(val, wt, W - wt[n - 1], n), unboundedKnapsack(val, wt, W, n - 1));

    }

    //Approach: Memoization
    public static int unboundedKnapsackMemo(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        return unboundedKnapsackMemo(val, wt, W, n, dp);
    }

    public static int unboundedKnapsackMemo(int[] val, int[] wt, int W, int n, int[][] dp) {
        //Base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != 0) {
            return dp[n][W];
        }

        //If weight of the nth item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
        if (wt[n - 1] > W) {
            dp[n][W] = unboundedKnapsackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }

        //Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        dp[n][W] = Math.max(val[n - 1] + unboundedKnapsackMemo(val, wt, W - wt[n - 1], n, dp),
                unboundedKnapsackMemo(val, wt, W, n - 1, dp));
        return dp[n][W];
    }

    //Approach: Dynamic Programming
    public static int unboundedKnapsackDP(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W ; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    //Approach: Dynamic Programming (Space Optimized)
    public static int unboundedKnapsackDPSpaceOptimized(int[] val, int[] wt, int W) {
        int n = val.length;
        int[] dp = new int[W + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W ; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[j] = Math.max(val[i - 1] + dp[j - wt[i - 1]], dp[j]);
                } else {
                    dp[j] = dp[j];
                }

            }
        }

        return dp[W];
    }


}
