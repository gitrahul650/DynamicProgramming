package adynamic;

public class CanCountMemoization {
    //Write a function countConstruct(target, wordBank) that accepts a target string and an array of strings.
    //The function should return the number of ways that the target can be constructed by concatenating elements of the wordBank array.
    //You may reuse elements of wordBank as many times as needed.
    //countConstruct(abcdef, [ab, abc, cd, def, abcd]) -> 1
    //countConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) -> 0
    //countConstruct('', [cat, dog, mouse]) -> 1
    //Please use memoization to solve this problem

    public static void main(String[] args) {
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        Integer[] memo = new Integer[target.length() + 1];
        System.out.println(countConstruct(target, wordBank, memo));
    }

    private static int countConstruct(String target, String[] wordBank, Integer[] memo) {
        if (target.isEmpty()) {
            return 1;
        }

        if (memo[target.length()] != null) {
            return memo[target.length()];
        }

        int totalCount = 0;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String newTarget = target.substring(word.length());
                int numWaysForRest = countConstruct(newTarget, wordBank, memo);
                totalCount += numWaysForRest;
            }
        }

        memo[target.length()] = totalCount;
        return totalCount;
    }
}
