package adynamic;

public class CanConstructTabulation {
    //Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
    //The function should return a boolean indicating whether or not the target can be constructed by concatenating elements of the wordBank array.
    //You may reuse elements of wordBank as many times as needed.
    //canConstruct(abcdef, [ab, abc, cd, def, abcd]) -> true
    //canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) -> false
    //canConstruct('', [cat, dog, mouse]) -> true

    //PLease use tabulation to solve this problem

    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(canConstruct(target, wordBank));
    }

    private static boolean canConstruct(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for (int i = 0; i < target.length(); i++) {
            if (table[i]) {
                for (String word : wordBank) {
                    if (target.substring(i).startsWith(word)) {
                        table[i + word.length()] = true;
                    }
                }
            }
        }

        return table[target.length()];
    }
}
