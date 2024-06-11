package a1Dynamic.LCS;

public class MinimumInsertionDeletionToConvertStrAToStrB04 {
    //Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
    // The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2.
    // It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
    // Example 1: Input : str1 = "heap", str2 = "pea"
    // Output : Minimum Deletion = 2 and
    //          Minimum Insertion = 1
    // p and h deleted from heap
    // Then, p is inserted at the beginning
    // One thing to note, though p was required yet
    // it was removed/deleted first from its position and
    // Example 2: Input : str1 = "geeksforgeeks", str2 = "geeks"\ Output : Minimum Deletion = 8
    //          Minimum Insertion = 0
    // Explanation:  String s1 = "geeksforgeeks" and s2 = "geeks" 1. Delete 7 characters from s1 so that string becomes "geeks"
    //Approach: Dynamic Programming
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        System.out.println(minimumInsertionDeletionToConvertStrAToStrB(s1, s2));
    }

    public static int minimumInsertionDeletionToConvertStrAToStrB(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        //Fill the dp table in bottom up manner
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //If the characters match, then add 1 to the result and move diagonally
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //If the characters don't match, then take the max of the two results
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return m + n - 2 * dp[m][n];
    }

}
