package a1Dynamic.MatrixChainMultiplication;

public class MatrixchainMultiplication {
    //Given a sequence of matrices, find the most efficient way to multiply these matrices together.
    //The problem is not actually to perform the multiplications, but merely to decide in which order
    // to perform the multiplications.
    //We have many options to multiply a chain of matrices because matrix multiplication is associative.
    //In other words, no matter how we parenthesize the product, the result will be the same.
    //For example, if we had four matrices A, B, C, and D, we would have:
    //    (ABC)D = (AB)(CD) = A(BCD) = ....
    //However, the order in which we parenthesize the product affects the number of simple arithmetic
    // operations needed to compute the product, or the efficiency.
    //For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix.
    //Then,

    //    (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
    //    A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
    //Clearly the first parenthesization requires less number of operations.
//Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of
//dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that should return the
//minimum number of multiplications needed to multiply the chain.

    //Approach: Recursive
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(matrixChainOrder(arr, 1, arr.length - 1));
        System.out.println("matrixChainOrderMemo ->"+matrixChainOrderMemo(arr, 1, arr.length - 1));
        System.out.println("matrixChainOrderDP ->"+matrixChainOrderDP(arr));
    }

    public static int matrixChainOrder(
            int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = matrixChainOrder(arr, i, k) +
                    matrixChainOrder(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    //Approach: Memoization
    public static int matrixChainOrderMemo(
            int[] arr, int i, int j) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        return matrixChainOrderMemo(arr, i, j, dp);
    }

    public static int matrixChainOrderMemo(
            int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = matrixChainOrderMemo(arr, i, k, dp) +
                    matrixChainOrderMemo(arr, k + 1, j, dp) +
                    arr[i - 1] * arr[k] * arr[j];
            if (count < min) {
                min = count;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    //Approach: Dynamic Programming
    public static int matrixChainOrderDP(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (j == n) {
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int count = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (count < dp[i][j]) {
                        dp[i][j] = count;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }
}
