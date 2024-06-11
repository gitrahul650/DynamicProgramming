package a1Dynamic.knapsack01;

public class NoOfSubsetGivenDifference05 {
   //Given an array arr[] of size N and a given difference diff, the task is to count the number of partitions that
    // we can perform such that the difference between the sum of the two subsets is equal to the given difference.
    //Example: arr[] = {1, 1, 2, 3}, diff = 1 ->
    //possible partitions are {1, 1, 2} & {3}, {1, 3} & {1, 2}, {1, 1, 3} & {2}
    //Approach: Dynamic Programming
    //The problem can be reduced to count of subsets sum with a given sum. The idea is to consider the last element
    // in every subset first and then recur for the remaining array elements with the sum equal to the difference of
    // the total sum of the two subsets and the current element.
    //The base cases of the above recursive approach will be:
    //1. If the sum is 0, then return 1 (Empty subset allowed)
    //2. If the sum is not 0 and the index is 0, then return 0.
    //3. If the last element is greater than the sum, then ignore it.
//4. Else, we can either include it in the subset or exclude it from the subset.

    public static void main(String[] args) {
        int[] set = {1, 1, 2, 3};
        int diff = 1;
        System.out.println("noOfSubsetGivenDifference(set, diff) = " + noOfSubsetGivenDifference(set, diff));
    }

    public static int noOfSubsetGivenDifference(int[] set, int diff) {
        int n = set.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += set[i];
        }

        int s1 = (diff + sum) / 2;
        return countOfSubsetSum(set, s1);
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
