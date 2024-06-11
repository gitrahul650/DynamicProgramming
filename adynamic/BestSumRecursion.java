package adynamic;

import java.util.ArrayList;
import java.util.List;

public class BestSumRecursion {
    //Write a function bestSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
    //The function should return an array containing the shortest combination of numbers that add up to exactly the targetSum.
    //If there is a tie for the shortest combination, you may return any one of the shortest.
    //Please use recursion for this
    //bestSum(7, [5, 3, 4, 7]) -> [7]
    //bestSum(8, [2, 3, 5]) -> [3, 5]
    //bestSum(8, [1, 4, 5]) -> [4, 4]
    //bestSum(100, [1, 2, 5, 25]) -> [25, 25, 25, 25]
    //bestSum(8, [1, 2, 4, 7]) -> null
    //bestSum(0, [1, 2, 3]) -> []

    public static void main(String[] args) {
        int targetSum = 100;
        //int[] numbers = {1, 2};
      //  System.out.println(bestSum(targetSum, numbers));
      //  System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(8, new int[]{5,2,3}));
    }

    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (targetSum < 0) {
            return null;
        }

        List<Integer> shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> resultCombination = bestSum(remainder, numbers);

            if (resultCombination != null) {
                List<Integer> combination = new ArrayList<>(resultCombination);
                combination.add(num);   //add the current number to the combination

                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        return shortestCombination;
    }
}
