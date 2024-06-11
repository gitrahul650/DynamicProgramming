package twopointerarray;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Create a map to store each number and its index
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement exists in the map
            if (numIndexMap.containsKey(complement)) {
                return new int[] { numIndexMap.get(complement), i };
            }
            // If complement does not exist, add the current number to the map
            numIndexMap.put(nums[i], i);
        }
        // Return an empty array if no solution is found
        return new int[0];
    }
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices of the two numbers that add up to the target: " + result[0] + ", " + result[1]);
            System.out.println("Numbers: " + nums[result[0]] + ", " + nums[result[1]]);
        }
    else {
        System.out.println("No solution found.");
    }
}
}

