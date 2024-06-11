package adynamic;

public class HowSumTabulation {
    //Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
    //The function should return an array containing any combination of elements
    // that add up to exactly that targetSum.
    // If there is no combination that adds up to the targetSum, then return null.
    // If there are multiple combinations possible, you may return any single one.
    //Please use tabulation for this
    //howSum(7, [5, 3, 4, 7]) -> [3, 4] or [7]
    //howSum(8, [2, 3, 5]) -> [2, 2, 2, 2] or [3, 5]
    //howSum(7, [2, 4]) -> null
    //howSum(0, [1, 2, 3]) -> []

    public static void main(String[] args) {
        int targetSum = 8;
        int[] numbers = {2, 3, 5};
        System.out.println(howSum(targetSum, numbers));
    }

    private static String howSum(int targetSum, int[] numbers) {
        String[] table = new String[targetSum + 1];
        table[0] = "";

        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int number : numbers) {
                    if (i + number <= targetSum) {
                        table[i + number] = table[i] + number;
                    }
                }
            }
        }

        return table[targetSum];
    }
}
