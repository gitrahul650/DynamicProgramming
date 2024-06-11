package a1Dynamic.knapsack01;

public class CountOfSubsetOfGivenSum03 {
    //Given a set of non-negative integers, and a value sum, determine the number of subset
    // of the given set with sum equal to given sum.
    //Example: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 -> 2
    //There are 2 subsets (4, 5) and (3, 4, 2) with sum 9.
    //Approach: Dynamic Programming

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("countOfSubsetSum(set, sum) = " + countOfSubsetSum(set, sum));
    }

    public static int countOfSubsetSum(int[] set, int sum) {
        int n = set.length;
        int[][] dp = new int[n + 1][sum + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }

        // Fill the subset table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum ; j++) {
                if (j < set[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //Excluding the current element
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }


}
