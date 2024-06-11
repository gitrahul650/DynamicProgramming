package adynamic;

import java.util.ArrayList;
import java.util.List;

public class AllConstructTabulation {
    //Write a function allConstruct(target, wordBank) that accepts a target string and an array of strings.
    //The function should return a 2D array containing all of the ways that the target can be constructed by concatenating elements of the wordBank array.
    // Each element of the 2D array should represent one combination that constructs the target.
    //You may reuse elements of wordBank as many times as needed.
    //allConstruct(purple, [purp, p, ur, le, purpl]) -> [[purp, le], [p, ur, p, le]]
    //allConstruct(abcdef, [ab, abc, cd, def, abcd, ef, c]) -> [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
    //allConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) -> []
    //allConstruct('', [cat, dog, mouse]) -> [[]]
    //Please use tabulation to solve this problem


    public static void main(String[] args) {
        String[] wordBank1 = {"purp", "p", "ur", "le", "purpl"};
        String target1 = "purple";
        System.out.println(allConstruct(target1, wordBank1)); // Output: [[purp, le], [p, ur, p, le]]

        String[] wordBank2 = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        String target2 = "abcdef";
        System.out.println(allConstruct(target2, wordBank2)); // Output: [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]

        String[] wordBank3 = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        String target3 = "skateboard";
        System.out.println(allConstruct(target3, wordBank3)); // Output: []

        String[] wordBank4 = {"cat", "dog", "mouse"};
        String target4 = "";
        System.out.println(allConstruct(target4, wordBank4)); // Output: [[]]

    }

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i <= target.length(); i++) {
            table.add(new ArrayList<>());
        }

        table.get(0).add(new ArrayList<>());

        for (int i = 0; i <= target.length(); i++) {
            for (String word : wordBank) {
                if (i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                    for (List<String> way : table.get(i)) {
                        List<String> newWay = new ArrayList<>(way);
                        newWay.add(word);
                        table.get(i + word.length()).add(newWay);
                    }
                }
            }
        }

        return table.get(target.length());
    }
}
