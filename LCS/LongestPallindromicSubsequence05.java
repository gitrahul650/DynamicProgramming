package a1Dynamic.LCS;

public class LongestPallindromicSubsequence05 {
    //Given a sequence, find the length of the longest palindromic subsequence in it.
    //As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as
    // “BABCBAB” is the longest palindromic subsequence in it.
    //“BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
    //Approach: Dynamic Programming

    public static void main(String[] args) {
        String s1 = "BBABCBCAB";
        System.out.println(lcs(s1));
        printLCS(s1);
    }

    public static int lcs(String s1) {
        int m = s1.length();
        int n = m;

        int[][] dp = new int[m + 1][n + 1];

        //Fill the dp table in bottom up manner
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s1.charAt(i - 1) == s1.charAt(n - j)) {
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

    //Print the longest pallindromic subsequence
    //Approach: Dynamic Programming

    public static void printLCS(String s1) {
        int m = s1.length();
        int n = m;

        int[][] dp = new int[m + 1][n + 1];

        //Fill the dp table in bottom up manner
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s1.charAt(i - 1) == s1.charAt(n - j)) {
                    //If the characters match, then add 1 to the result and move diagonally
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //If the characters don't match, then take the max of the two results
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        //Print the longest pallindromic subsequence
        int i = m;
        int j = n;
        String result = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s1.charAt(n - j)) {
                result = s1.charAt(i - 1) + result;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println(result);
    }

}
