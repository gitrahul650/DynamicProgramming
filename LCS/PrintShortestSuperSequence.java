package a1Dynamic.LCS;

public class PrintShortestSuperSequence {
    //Given two strings ‘X’ and ‘Y’, yprin the shortest supersequence such that both strings are subsequence
    // of the supersequence.
    // Examples : Input:   str1 = "geek",  str2 = "eke"  Output: "geeke"
    //Approach: Dynamic Programming

      public static void main(String[] args) {
//        String s1 = "abcdgh";
//        String s2 = "abedfhr";
        String s1 = "geek";
        String s2 = "eke";
        System.out.println(printShortestCommonSupersequence(s1, s2));
      }

        public static String printShortestCommonSupersequence(String s1, String s2) {
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

            //print the shortest common supersequence
            int i = m;
            int j = n;
            StringBuilder sb = new StringBuilder();
            while (i > 0 && j > 0) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    sb.append(s1.charAt(i - 1));
                    i--;
                    j--;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        sb.append(s1.charAt(i - 1));
                        i--;
                    } else {
                        sb.append(s2.charAt(j - 1));
                        j--;
                    }
                }
            }

            while (i > 0) {
                sb.append(s1.charAt(i - 1));
                i--;
            }

            while (j > 0) {
                sb.append(s2.charAt(j - 1));
                j--;
            }

            return sb.reverse().toString();
        }
}

