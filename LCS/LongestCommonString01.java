package a1Dynamic.LCS;

public class LongestCommonString01 {
    //  Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
    //  Input : X = “abcdxyz”, y = “xyzabcd”
    //  Output : 4
    //  The longest common substring is “abcd” and is of length 4.

    //  Input : X = “zxabcdezy”, y = “yzabcdezx”    //  Output : 6


    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        System.out.println(lcs(s1, s2));
    }

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        //Fill the dp table in bottom up manner
        int max = 0;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //If the characters match, then add 1 to the result and move diagonally
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    //If the characters don't match, then take the max of the two results
                    dp[i][j] = 0;
                }

            }
        }

        return max;
    }
}
