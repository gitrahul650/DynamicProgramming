package a1Dynamic.MatrixChainMultiplication;

public class BooleanParenthesis {
    //Given a boolean expression with following symbols.
    // Symbols 'T' ---> true 'F' ---> false And
    // following operators filled between symbols // Operators & ---> boolean AND | ---> boolean OR ^ ---> boolean XOR
    // Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
    // For Example:
    // Expression: T|T&F^T
    // Ways: ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
    // Expression: T^F|F
    // Ways: (T^(F|F)), ((T^F)|F)
    // Expression: T|F^T&T
    // Ways: (T|(F^(T&T))), (((T|F)^T)&T), (T|((F^T)&T)), (T|((F^T)&T))

    //Approach: Recursive
    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(countWays(s, 0, s.length() - 1, true));
    }

    public static int countWays(
            String s, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int lT = countWays(s, i, k - 1, true);
            int lF = countWays(s, i, k - 1, false);
            int rT = countWays(s, k + 1, j, true);
            int rF = countWays(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += lT * rT;
                } else {
                    ans += lT * rF + lF * rT + lF * rF;
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += lT * rT + lT * rF + lF * rT;
                } else {
                    ans += lF * rF;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    ans += lT * rF + lF * rT;
                } else {
                    ans += lT * rT + lF * rF;
                }
            }
        }
        return ans;
    }

    //Approach: Memoization
    public static int countWaysMemo(
            String s, int i, int j, boolean isTrue) {
        int[][][] dp = new int[s.length() + 1][s.length() + 1][2];
        return countWaysMemo(s, i, j, isTrue, dp);
    }

    public static int countWaysMemo(
            String s, int i, int j, boolean isTrue, int[][][] dp) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (isTrue) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if (dp[i][j][isTrue ? 1 : 0] != 0) {
            return dp[i][j][isTrue ? 1 : 0];
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int lT = countWaysMemo(s, i, k - 1, true, dp);
            int lF = countWaysMemo(s, i, k - 1, false, dp);
            int rT = countWaysMemo(s, k + 1, j, true, dp);
            int rF = countWaysMemo(s, k + 1, j, false, dp);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += lT * rT;
                } else {
                    ans += lT * rF + lF * rT + lF * rF;
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += lT * rT + lT * rF + lF * rT;
                } else {
                    ans += lF * rF;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    ans += lT * rF + lF * rT;
                } else {
                    ans += lT * rT + lF * rF;
                }
            }
        }
        return dp[i][j][isTrue ? 1 : 0] = ans;
    }

    //Approach: Tabulation
    public static int countWaysTab(String s, int i, int j, boolean isTrue) {
        int[][][] dp = new int[s.length() + 1][s.length() + 1][2];
        for (int gap = 0; gap < s.length(); gap++) {
            for (i = 0, j = gap; j < s.length(); i++, j++) {
                if (i == j) {
                    if (isTrue) {
                        dp[i][j][1] = s.charAt(i) == 'T' ? 1 : 0;
                    } else {
                        dp[i][j][0] = s.charAt(i) == 'F' ? 1 : 0;
                    }
                } else {
                    for (int k = i + 1; k < j; k += 2) {
                        int lT = dp[i][k - 1][1];
                        int lF = dp[i][k - 1][0];
                        int rT = dp[k + 1][j][1];
                        int rF = dp[k + 1][j][0];

                        if (s.charAt(k) == '&') {
                            if (isTrue) {
                                dp[i][j][1] += lT * rT;
                            } else {
                                dp[i][j][0] += lT * rF + lF * rT + lF * rF;
                            }
                        } else if (s.charAt(k) == '|') {
                            if (isTrue) {
                                dp[i][j][1] += lT * rT + lT * rF + lF * rT;
                            } else {
                                dp[i][j][0] += lF * rF;
                            }
                        } else if (s.charAt(k) == '^') {
                            if (isTrue) {
                                dp[i][j][1] += lT * rF + lF * rT;
                            } else {
                                dp[i][j][0] += lT * rT + lF * rF;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1][isTrue ? 1 : 0];
    }

    
}
