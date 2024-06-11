package abacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSum402 {
    //: Given a set of array numbers (without duplicates) and a target number
    //(target), find all unique combinations in the array where the numbers sum to target.
    //The same repeated number may be chosen from array unlimited number of times.
    //Note:
    //All numbers (including target) will be positive integers.
    //The solution set must not contain duplicate combinations
    //Example 1:
    //Input: candidates = [2,3,6,7], target = 7,
    //A solution set is:
    //[
    //  [7],
    //  [2,2,3]

    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 7};
        int target = 7;
        System.out.println("numbers = " + Arrays.toString(numbers));
        System.out.println("target = " + target);
        System.out.println("uniqueSum(numbers, target) = " + uniqueSum(numbers, target));
    }

    private static List<List<Integer>> uniqueSum(int[] numbers, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);
        uniqueSum(numbers, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void uniqueSum(int[] numbers, int target, List<Integer> list, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < numbers.length; i++) {
                if (i > start && numbers[i] == numbers[i - 1]) {
                    continue;
                }
                list.add(numbers[i]);
                uniqueSum(numbers, target - numbers[i], list, result, i);
                list.remove(list.size() - 1);
            }
        }
    }

    //: Given a set of array numbers (without duplicates) and a target number
    //(target), find all unique combinations in the array where the numbers sum to target.
    //The same repeated number may be chosen from array unlimited number of times.
    //Note:
    //All numbers (including target) will be positive integers.
    //The solution set must not contain duplicate combinations
    //Example 1:
    //Input: candidates = [2,3,6,7], target = 7,
    //A solution set is:
    //[
    //  [7],
    //  [2,2,3]

}
