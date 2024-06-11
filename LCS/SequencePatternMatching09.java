package a1Dynamic.LCS;

public class SequencePatternMatching09 {
    //Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    //A subsequence of a string is a new string that is formed from the original string by
    // deleting some (can be none) of the characters without disturbing the
    // relative positions of the
    // remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
    //
    //Example 1:
    //Input: s = "abc", t = "ahbgdc"
    //Output: true

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        //Fill the dp table in bottom up manner
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //If the characters match, then add 1 to the result and move diagonally
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //If the characters don't match, then take the max of the two results
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[m][n] == m;
    }


}
