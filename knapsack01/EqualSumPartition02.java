package a1Dynamic.knapsack01;

public class EqualSumPartition02 {
    //The partition problem is to determine whether a given set can be partitioned
    //into two subsets such that the sum of elements in both subsets is the same.
    //Examples:
    //arr[] = {1, 5, 11, 5}
    //Output: true
    //The array can be partitioned as {1, 5, 5} and {11}
    //please use dynamic programming approach

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        System.out.println("isEqualSumPartition(arr) = " + isEqualSumPartition(arr));
    }

    public static boolean isEqualSumPartition(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = arr.length;
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
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //Excluding the current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    



}
