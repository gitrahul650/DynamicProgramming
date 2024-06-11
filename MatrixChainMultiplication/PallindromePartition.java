package a1Dynamic.MatrixChainMultiplication;

public class PallindromePartition {
    // Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
    // For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
    // Determine the fewest cuts needed for palindrome partitioning of a given string.
    // For example, minimum 3 cuts are needed for “ababbbabbababa”.

    //Approach: Recursive
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(minCuts(s, 0, s.length() - 1));
    }

    public static int minCuts(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (isPallindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = minCuts(s, i, k) + minCuts(s, k + 1, j) + 1;
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    public static boolean isPallindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    //Approach: Memoization
    public static int minCutsMemo(String s, int i, int j) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        return minCutsMemo(s, i, j, dp);
    }

    public static int minCutsMemo(String s, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (isPallindrome(s, i, j)) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = minCutsMemo(s, i, k, dp) +
                    minCutsMemo(s, k + 1, j, dp) + 1;
            if (count < min) {
                min = count;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    //Approach: Dynamic
    public static int minCutsDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (isPallindrome(s, i, j)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int count = dp[i][k] + dp[k + 1][j] + 1;
                        if (count < dp[i][j]) {
                            dp[i][j] = count;
                        }
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

    //Approach: Try to find it in most optimized way


}

