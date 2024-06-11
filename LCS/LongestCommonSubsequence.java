package a1Dynamic.LCS;

public class LongestCommonSubsequence {
    //Given two sequences, find the length of longest subsequence present in both of them.
    //A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
    //For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
    //So a string of length n has 2^n different possible subsequences.
    //Example: s1 = "abcdgh"; s2 = "abedfhr" -> "abdh" -> 4
    //Approach: Recursive


    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }

    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }

    //Approach: Memoization
    public static int lcsMemo(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return lcsMemo(s1, s2, m, n, dp);
    }

    public static int lcsMemo(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, dp);
            return dp[m][n];
        } else {
            dp[m][n] = Math.max(lcsMemo(s1, s2, m - 1, n, dp), lcsMemo(s1, s2, m, n - 1, dp));
            return dp[m][n];
        }
    }

   //Approach: Dynamic Programming

        public static int lcsDP(String s1, String s2) {
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

            return dp[m][n];
        }




}
