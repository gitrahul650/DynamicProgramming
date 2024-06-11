package abacktracking;

public class NumberPower701 {
    //Given an integer x and a positive number n, write a efficient algorithm to
    //computes x^n

    public static void main(String[] args) {
        System.out.println(power(3, 4));
    }

    private static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
