package adynamic;

import java.util.ArrayList;
import java.util.List;

public class BestSumTabulation {
    //Write a function bestSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
    //The function should return an array containing the shortest combination of numbers that add up to exactly the targetSum.
    //If there is a tie for the shortest combination, you may return any one of the shortest.
    //Please use tabulation for this
    //bestSum(7, [5, 3, 4, 7]) -> [7]
    //bestSum(8, [2, 3, 5]) -> [3, 5]
    //bestSum(8, [1, 4, 5]) -> [4, 4]
//bestSum(100, [1, 2, 5, 25]) -> [25, 25, 25, 25]
    //bestSum(8, [1, 2, 4, 7]) -> null
    //bestSum(0, [1, 2, 3]) -> []

    public static void main(String[] args) {
        int targetSum = 100;
        int[] numbers = {1, 2, 5, 25};
        System.out.println(bestSum(targetSum, numbers));
    }

    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            table.add(null);
        }
        table.set(0, new ArrayList<>());

        for (int i = 0; i <= targetSum; i++) {
            if (table.get(i) != null) {
                for (int num : numbers) {
                    if (i + num <= targetSum) {
                        List<Integer> combination = new ArrayList<>(table.get(i));
                        combination.add(num);
                        if (table.get(i + num) == null || combination.size() < table.get(i + num).size()) {
                            table.set(i + num, combination);
                        }
                    }
                }
            }
        }

        return table.get(targetSum);
    }

}
