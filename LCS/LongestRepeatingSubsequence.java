package a1Dynamic.LCS;

public class LongestRepeatingSubsequence {
    //Given a string, find the length of the longest repeating subsequence such that the two subsequences don't have
    //same string character at the same position, i.e., any i'th character in the two subsequences shouldn't have the
    //same index in the original string.
    //Example: s1 = "aabebcdd" -> "abd" -> 3
    //Example: s1 = "aabb" -> "ab" -> 2
    //Approach: Dynamic Programming

    public static void main(String[] args) {
        String s1 = "aabebcdd";
        System.out.println(lrs(s1));
    }

    public static int lrs(String s1) {
        String s2 = s1;
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        //Fill the dp table in bottom up manner
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                    //If the characters match, then add 1 to the result and move diagonally
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //If the characters don't match, then take the max of the two results
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[m][n];
    }

}
