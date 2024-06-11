package adynamic;

public class CanSumMemoization {
    //Write a function canSum(targetSum, numbers)
    // that takes in a targetSum and an array of numbers as arguments.

    //The function should return a boolean indicating whether or
    // not it is possible to generate the targetSum using numbers from the array.

    //You may use an element of the array as many times as needed.

    //You may assume that all input numbers are nonnegative.

    //canSum(7, [5, 3, 4, 7]) -> true
    //canSum(7, [2, 4]) -> false

    //PLease use memoization to solve this problem

    public static void main(String[] args) {
        int targetSum = 300;
        int[] numbers = {7, 14};
        Boolean[] memo = new Boolean[targetSum + 1];
        System.out.println(canSum(targetSum, numbers, memo));
    }

    private static boolean canSum(int targetSum, int[] numbers, Boolean[] memo) {
        if (targetSum == 0) {
            return true;
        }

        if (targetSum < 0) {
            return false;
        }

        if (memo[targetSum] != null) {
            return memo[targetSum];
        }

        for (int number : numbers) {
            int newTargetSum = targetSum - number;
            if (canSum(newTargetSum, numbers, memo)) {
                memo[targetSum] = true;
                return true;
            }
        }

        memo[targetSum] = false;
        return false;
    }
}
