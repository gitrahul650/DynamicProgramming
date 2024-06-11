package adynamic;

public class CanSumTabulation {
    //Write a function canSum(targetSum, numbers)
    // that takes in a targetSum and an array of numbers as arguments.

    //The function should return a boolean indicating whether or
    // not it is possible to generate the targetSum using numbers from the array.

    //You may use an element of the array as many times as needed.

    //You may assume that all input numbers are nonnegative.

    //canSum(7, [5, 3, 4, 7]) -> true
    //canSum(7, [2, 4]) -> false

    //PLease use tabulation to solve this problem

    public static void main(String[] args) {
        int targetSum = 300;
        int[] numbers = {7, 14};
        System.out.println(canSum(targetSum, numbers));
    }

    private static boolean canSum(int targetSum, int[] numbers) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;

        for (int i = 0; i <= targetSum; i++) {
            if (table[i]) {
                for (int number : numbers) {
                    if (i + number <= targetSum) {
                        table[i + number] = true;
                    }
                }
            }
        }

        return table[targetSum];
    }


}
