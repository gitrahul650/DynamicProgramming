package adynamic;

public class CanSumRecursion {
    //Write a function canSum(targetSum, numbers)
    // that takes in a targetSum and an array of numbers as arguments.

    //The function should return a boolean indicating whether or
    // not it is possible to generate the targetSum using numbers from the array.

    //You may use an element of the array as many times as needed.

    //You may assume that all input numbers are nonnegative.

    //canSum(7, [5, 3, 4, 7]) -> true
    //canSum(7, [2, 4]) -> false

    public static void main(String[] args) {
        int targetSum = 300;
        int[] numbers = {7, 14};
      //  System.out.println(canSum(targetSum, numbers));
       // System.out.println(canSum(7, new int[]{5, 3, 4, 7})); // Output: true
     //   System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(4, new int[]{5,1}));
    }

    public static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return true;
        }

        if (targetSum < 0) {
            return false;
        }

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum(remainder, numbers)) {
                return true;
            }
        }

        return false;
    }

}
