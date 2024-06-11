package adynamic;

import java.util.Arrays;

public class HowSumRecursion {

    //Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
    //The function should return an array containing any combination of elements
    // that add up to exactly that targetSum.
    // If there is no combination that adds up to the targetSum, then return null.
    // If there are multiple combinations possible, you may return any single one.
    //Please use recursion for this
    //howSum(7, [5, 3, 4, 7]) -> [3, 4] or [7]
    //howSum(8, [2, 3, 5]) -> [2, 2, 2, 2] or [3, 5]
    //howSum(7, [2, 4]) -> null
    //howSum(0, [1, 2, 3]) -> []

    public static void main(String[] args) {
        int targetSum = 7;
        int[] numbers = {5, 3, 4, 7};
        System.out.println(Arrays.toString(howSum(targetSum, numbers)));
    }

    private static int[] howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return new int[0];
        }

        if (targetSum < 0) {
            return null;
        }

        for (int number : numbers) {
            int newTargetSum = targetSum - number;
            int[] result = howSum(newTargetSum, numbers);
            if (result != null) {
                int[] newResult = new int[result.length + 1];
                System.arraycopy(result, 0, newResult, 0, result.length);
                newResult[newResult.length - 1] = number;
                return newResult;
            }
        }

        return null;
    }
}
