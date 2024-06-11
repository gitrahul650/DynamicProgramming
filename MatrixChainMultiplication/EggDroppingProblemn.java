package a1Dynamic.MatrixChainMultiplication;

public class EggDroppingProblemn {
    //Given a certain number of floors and a certain number of eggs, find the minimum number of attempts needed to
    // find the threshold floor from which the egg breaks.
    //An egg that survives a fall can be used again.
    //A broken egg must be discarded.
    //For example, if the threshold is 16 and we have 2 eggs, then the minimum number of attempts is 4.
    //We can drop from floor 10, 16, 13, 14, 15
    //Approach: Recursive
    public static void main(String[] args) {
        int floors = 16;
        int eggs = 2;
        System.out.println(minAttempts(floors, eggs));
    }

    public static int minAttempts(int floors, int eggs) {
        if (floors == 0 || floors == 1 || eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int count = 1 + Math.max(minAttempts(i - 1,
                            eggs - 1),
                    minAttempts(floors - i, eggs));
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    //Approach: Memoization
    public static int minAttemptsMemo(int floors, int eggs) {
        int[][] dp = new int[floors + 1][eggs + 1];
        return minAttemptsMemo(floors, eggs, dp);
    }

    public static int minAttemptsMemo(int floors, int eggs, int[][] dp) {
        if (floors == 0 || floors == 1 || eggs == 1) {
            return floors;
        }

        if (dp[floors][eggs] != 0) {
            return dp[floors][eggs];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int count = 1 + Math.max(minAttemptsMemo(i - 1, eggs - 1, dp),
                    minAttemptsMemo(floors - i, eggs, dp));
            if (count < min) {
                min = count;
            }
        }
        dp[floors][eggs] = min;
        return dp[floors][eggs];
    }

    //Approach: Dynamic Programming
    public static int minAttemptsDP(int floors, int eggs) {
        int[][] dp = new int[floors + 1][eggs + 1];

        for (int i = 1; i <= floors; i++) {
            dp[i][1] = i;
        }

        for (int i = 1; i <= eggs; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= floors; i++) {
            for (int j = 2; j <= eggs; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    int count = 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]);
                    if (count < dp[i][j]) {
                        dp[i][j] = count;
                    }
                }
            }
        }
        return dp[floors][eggs];
    }


}
