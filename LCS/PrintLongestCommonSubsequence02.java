package a1Dynamic.LCS;

public class PrintLongestCommonSubsequence02 {
//Given two sequences, print the longest subsequence present in both of them.
    //A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
    //Approach: Dynamic Programming

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        System.out.println(lcs(s1, s2));
    }

    public static String lcs(String s1, String s2) {
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

        //Now, we need to print the longest common subsequence
        //Start from the bottom right corner of the dp table
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            //If the characters match, then add the character to the result and move diagonally
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                //If the characters don't match, then move in the direction of the larger result
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return sb.reverse().toString();
    }



}
