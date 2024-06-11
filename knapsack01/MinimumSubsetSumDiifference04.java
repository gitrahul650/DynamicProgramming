package a1Dynamic.knapsack01;

public class MinimumSubsetSumDiifference04 {
    //Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference
    // between their sums is minimum.
    //If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements
    // and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
    //Example: set[] = {3, 1, 4, 2, 2, 1}, sum = 9 -> 1
    //The minimum difference between sum of two subsets is 1
    //
    // {1, 3, 4} & {1, 2, 2}
    //Approach: Dynamic Programming

    public static void main(String[] args) {
        //int[] set = {3, 1, 4, 2, 2, 1};
        int[] set = {1, 6, 11, 5};
        System.out.println("minimumSubsetSumDifference(set) = " + minimumSubsetSumDifference(set));
    }

    public static int minimumSubsetSumDifference(int[] set) {
        int n = set.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += set[i];
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        // Fill the subset table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum ; j++) {
                if (j < set[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //Excluding the current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }

        return diff;
    }
}
