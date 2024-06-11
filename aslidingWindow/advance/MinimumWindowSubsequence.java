package aslidingWindow.advance;

public class MinimumWindowSubsequence {
    //Given two strings s1 and s2, return the minimum contiguous substring part of s1,
    // so that s2 is a subsequence of the part.
    //If there is no such window in s1 that covers all characters in s2, return the empty string "".
    //If there are multiple such minimum-length windows, return the one with the left-most starting index.
    //Example 1:    Input: s1 = "abcdebdde", s2 = "bde"    Output: "bcde"
    //Explanation: "bcde" is the answer because it occurs before "bdde" which has the same length.
    // "deb" is not a smaller window because the elements of s2 in the window must occur in order.

    public static void main(String[] args) {
        String s1 = "this is a test string";
        String s2 = "tist";
        String result = minWindow1(s1, s2);
        System.out.println("Minimum Window: " + result);
    }


    public static String minWindow1(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= Math.min(i, len2); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // match
                } else {
                    dp[i][j] = dp[i - 1][j]; // skip
                }
            }
        }

        int start = 0;
        int minLen = len1 + 1;
        for (int i = len2; i <= len1; i++) {
            if (dp[i][len2] != 0) {
                if (i - dp[i][len2] + 1 < minLen) {
                    minLen = i - dp[i][len2] + 1;
                    start = dp[i][len2] - 1;
                }
            }
        }

        return minLen == len1 + 1 ? "" : s1.substring(start, start + minLen);



    }

}

