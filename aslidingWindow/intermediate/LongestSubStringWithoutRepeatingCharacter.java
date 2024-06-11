package aslidingWindow.intermediate;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
//Given a string, find the length of the longest substring without repeating characters.
    public static int longestSubstringLength(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char rightChar = s.charAt(j);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);
            while (charFrequency.get(rightChar) > 1) {
                char leftChar = s.charAt(i);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abcbcbbcade";
        int result = longestSubstringLength(s);
        System.out.println("Longest Substring Length: " + result);
    }

        }
