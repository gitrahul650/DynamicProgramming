package a1Dynamic.LCS;

public class MinDeletionsToMakePallindrome10 {
   //Minimum number of deletions to make a string palindrome
    //Given a string of size ‘n’. The task is to remove or delete minimum number of
    // characters from the string so that the resultant string is palindrome.
    //Examples :
    //
    //Input : aebcbda
    //Output : 2
    //Remove characters 'e' and 'd'
    //Resultant string will be 'abcba'
    //which is a palindromic string

    //Approach: Dynamic Programming
    public static void main(String[] args) {
        String s1 = "aebcbda";
        String s2 = new StringBuilder(s1).reverse().toString();
        System.out.println("Min Deletions: " + minDeletions(s1, s2));
    }

    public static int minDeletions(String s1, String s2) {
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


}
