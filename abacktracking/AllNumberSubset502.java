package abacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllNumberSubset502 {
    //Given a set of positive integers, find all its subsets
    //Example:
    //Input: [1, 2, 3]
    //Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
    //Explanation: The different subsets are basically the powerset of the given array.
    //Note: The solution set must not contain duplicate subsets.
    //Example:
    //Input: [1, 2, 2]
    //Output: [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
    //Explanation: The solution set must not contain duplicate subsets.
    //Note: The solution set must not contain duplicate subsets.
    //Example:
    //Input: [1, 2, 3]
    //Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
    //Explanation: The different subsets are basically the powerset of the given array.
    //Note: The solution set must not contain duplicate subsets.
    //Example:
    //Input: [1, 2, 2]
    //Output: [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
    //Explanation: The solution set must not contain duplicate subsets.
    //Note: The solution set must not contain duplicate subsets.
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println("numbers = " + Arrays.toString(numbers));
        System.out.println("allNumberSubset(numbers) = " + allNumberSubset(numbers));
    }

    private static List<List<Integer>> allNumberSubset(int[] numbers) {
      List<List<Integer>> result = new ArrayList<>();
        allNumberSubset(numbers, new ArrayList<>(), result, 0);
        return result;
    }

    private static void allNumberSubset(int[] numbers, List<Integer> list, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < numbers.length; i++) {
            list.add(numbers[i]);
            allNumberSubset(numbers, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
