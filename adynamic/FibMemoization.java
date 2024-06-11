package adynamic;

public class FibMemoization {

    public static void main(String[] args) {
        int n = 100 ;
        long[] memo = new long[n + 1];
        System.out.println(fib(n, memo));
    }

    private static long fib(long n, long[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[(int) n] != 0) {
            return memo[(int) n];
        }

        memo[(int) n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[(int) n];
    }

//    //use recursion to solve fibonacci
//    public static void main(String[] args) {
//        long n = 50;
//        System.out.println(fib(n));
//    }
//
//    private static long fib(long n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        return fib(n - 1) + fib(n - 2);
//    }
}
