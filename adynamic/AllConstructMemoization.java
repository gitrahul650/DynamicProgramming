package adynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstructMemoization {
    //Write a function allConstruct(target, wordBank) that accepts a target string and an array of strings.
    //The function should return a 2D array containing all of the ways that the target can be constructed by concatenating elements of the wordBank array.
    // Each element of the 2D array should represent one combination that constructs the target.
    //You may reuse elements of wordBank as many times as needed.
    //allConstruct(purple, [purp, p, ur, le, purpl]) -> [[purp, le], [p, ur, p, le]]
    //allConstruct(abcdef, [ab, abc, cd, def, abcd, ef, c]) -> [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
    //allConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]) -> []
    //allConstruct('', [cat, dog, mouse]) -> [[]]
    //Please use memoization to solve this problem

    public static void main(String[] args) {
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        System.out.println(allConstruct(target, wordBank));
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        return allConstruct(target, wordBank, new HashMap<>());
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.equals("")) {
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<String>> allWays = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);
                for (List<String> way : suffixWays) {
                    List<String> combination = new ArrayList<>();
                    combination.add(word);
                    combination.addAll(way);
                    allWays.add(combination);
                }
            }
        }

        memo.put(target, allWays);
        return allWays;
    }


}
