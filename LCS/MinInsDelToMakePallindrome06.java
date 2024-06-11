package a1Dynamic.LCS;

public class MinInsDelToMakePallindrome06 {
    //Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
    //For Example:
    //ab: Number of insertions required is 1. bab or aba
    //aa: Number of insertions required is 0. aa
    //abcd: Number of insertions required is 3. dcbabcd
    //abcd: Number of insertions required is 3. dcbabcd or abcacba or abcdcba or abcba
    //abcda: Number of insertions required is 2. adcbcda which is same as number of deletions in adcbcba
    //abcde: Number of insertions required is 4. edcbabcde
    //Approach: Dynamic Programming

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("Min Insertions: " + minInsertions(s1, s2));
    }

    public static int minInsertions(String s1, String s2) {
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

        return m - dp[m][n];
    }

    //
    

}
