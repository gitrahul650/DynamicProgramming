package adynamic;

import java.util.HashMap;
import java.util.Map;

public class CanSumMemoization1 {

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{5, 3, 4, 7})); // Output: true
        System.out.println(canSum(7, new int[]{2, 4}));        // Output: false
    }

    public static boolean canSum(int targetSum, int[] numbers) {
        return canSum(targetSum, numbers, new HashMap<>());
    }

    public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum == 0) {
            return true;
        }

        if (targetSum < 0) {
            return false;
        }

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }
}
