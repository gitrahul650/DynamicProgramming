package abacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleLetterCombination202 {
    /// Given a string containing digits from 2-9 inclusive, return all possible
    //letter combinations that the number could represent
    //Return the answer in any order
    //A mapping of digit to letters (just like on the telephone buttons) is given below
    //Note that 1 does not map to any letters
    //2 -> a, b, c
    //3 -> d, e, f
    //4 -> g, h, i
    //5 -> j, k, l
    //6 -> m, n, o
    //7 -> p, q, r, s
    //8 -> t, u, v
    //9 -> w, x, y, z
    //Example 1:
    //Input: digits = "23"
    //Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    //Example 2:
    //Input: digits = ""
    //Output: []
    //Example 3:
    //Input: digits = "2"
    //Output: ["a","b","c"]
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        letterCombinations(digits, 0, digitToLetters, new StringBuilder(), result);
        return result;
    }

    private static void letterCombinations(String digits, int index, Map<Character, String> digitToLetters, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            letterCombinations(digits, index + 1, digitToLetters, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
