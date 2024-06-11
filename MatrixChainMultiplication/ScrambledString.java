package a1Dynamic.MatrixChainMultiplication;

public class ScrambledString {
    //Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
    //A string is a scrambled string of another string if it can be obtained by swapping some characters of the other string.
    //Example: s1 = "great", s2 = "rgeat" -> true
    //Example: s1 = "abcde", s2 = "caebd" -> false

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScrambled(s1, s2));
    }

    //Approach: Recursive
    public static boolean isScrambled(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() <= 1) {
            return false;
        }

        int n = s1.length();
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if ((isScrambled(s1.substring(0, i), s2.substring(n - i))
                    && isScrambled(s1.substring(i), s2.substring(0, n - i))) ||
                    (isScrambled(s1.substring(0, i), s2.substring(0, i)) &&
                            isScrambled(s1.substring(i), s2.substring(i)))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Approach: Memoization
    public static boolean isScrambledMemo(String s1, String s2) {
        int n = s1.length();
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        return isScrambledMemo(s1, s2, dp, 0, 0, n);
    }

    public static boolean isScrambledMemo(
            String s1, String s2, int[][][] dp, int i, int j, int len) {
        if (i >= len || j >= len) {
            return false;
        }

        if (s1.substring(i).equals(s2.substring(j))) {
            return true;
        }

        if (len == 1) {
            return s1.charAt(i) == s2.charAt(j);
        }

        if (dp[i][j][len] != 0) {
            return dp[i][j][len] == 1;
        }

        boolean flag = false;
        for (int k = 1; k < len; k++) {
            if ((isScrambledMemo(s1, s2, dp, i, j + len - k, k) &&
                    isScrambledMemo(s1, s2, dp, i + k, j, len - k)) ||
                    (isScrambledMemo(s1, s2, dp, i, j, k) &&
                            isScrambledMemo(s1, s2, dp, i + k, j + k, len - k))) {
                flag = true;
                break;
            }
        }
        dp[i][j][len] = flag ? 1 : -1;
        return flag;
    }

    //Approach: Dynamic Programming
    public static boolean isScrambledDP(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    if (len == 1) {
                        dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int k = 1; k < len; k++) {
                            if ((dp[i][j + len - k][k] && dp[i + k][j][len - k]) ||
                                    (dp[i][j][k] && dp[i + k][j + k][len - k])) {
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }



}
