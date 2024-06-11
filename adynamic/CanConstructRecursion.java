package adynamic;

public class CanConstructRecursion {
    //Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
    //The function should return a boolean indicating whether or not the target can be constructed by concatenating elements of the wordBank array.
    //You may reuse elements of wordBank as many times as needed.
    //canConstruct(abcdef, [ab, abc, cd, def, abcd]) -> true
    //canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) -> false
    //canConstruct('', [cat, dog, mouse]) -> true

    //PLease use recursion to solve this problem

    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(canConstruct(target, wordBank));
    }

    private static boolean canConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) {
            return true;
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String newTarget = target.substring(word.length());
                if (canConstruct(newTarget, wordBank)) {
                    return true;
                }
            }
        }

        return false;
    }

}
