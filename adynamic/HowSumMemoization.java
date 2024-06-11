package adynamic;

public class HowSumMemoization {
    //Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
    //The function should return an array containing any combination of elements
    // that add up to exactly that targetSum.
    // If there is no combination that adds up to the targetSum, then return null.
    // If there are multiple combinations possible, you may return any single one.
    //howSum(7, [5, 3, 4, 7]) -> [3, 4] or [7]
    //howSum(8, [2, 3, 5]) -> [2, 2, 2, 2] or [3, 5]
    //howSum(7, [2, 4]) -> null
    //howSum(0, [1, 2, 3]) -> []

    //Please use memoization for this
    //howSum(7, [5, 3, 4, 7]) -> [3, 4] or [7]
    //howSum(8, [2, 3, 5]) -> [2, 2, 2, 2] or [3, 5]
    //howSum(7, [2, 4]) -> null
    //howSum(0, [1, 2, 3]) -> []

    public static void main(String[] args) {
        int targetSum = 7;
        int[] numbers = {5, 3, 4, 7};
        System.out.println(howSum(targetSum, numbers));
    }

    private static String howSum(int targetSum, int[] numbers) {
        String[] memo = new String[targetSum + 1];
        return howSumHelper(targetSum, numbers, memo);
    }

    private static String howSumHelper(int targetSum, int[] numbers, String[] memo) {
        if (memo[targetSum] != null) {
            return memo[targetSum];
        }

        if (targetSum == 0) {
            return "";
        }

        if (targetSum < 0) {
            return null;
        }

        for (int number : numbers) {
            int newTargetSum = targetSum - number;
            String result = howSumHelper(newTargetSum, numbers, memo);
            if (result != null) {
                memo[targetSum] = result + number;
                return memo[targetSum];
            }
        }

        memo[targetSum] = null;
        return null;
    }

}
