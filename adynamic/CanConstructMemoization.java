package adynamic;

public class CanConstructMemoization {
    //Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
    //The function should return a boolean indicating whether or not the target can be constructed by concatenating elements of the wordBank array.
    //You may reuse elements of wordBank as many times as needed.
    //canConstruct(abcdef, [ab, abc, cd, def, abcd]) -> true
    //canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) -> false
    //canConstruct('', [cat, dog, mouse]) -> true

    //PLease use memoization to solve this problem

    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        Boolean[] memo = new Boolean[target.length() + 1];
        System.out.println(canConstruct(target, wordBank, memo));
    }

    private static boolean canConstruct(String target, String[] wordBank, Boolean[] memo) {
        if (target.isEmpty()) {
            return true;
        }

        if (memo[target.length()] != null) {
            return memo[target.length()];
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String newTarget = target.substring(word.length());
                if (canConstruct(newTarget, wordBank, memo)) {
                    memo[target.length()] = true;
                    return true;
                }
            }
        }

        memo[target.length()] = false;
        return false;
    }
}
