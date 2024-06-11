package aslidingWindow.advance;

import java.util.HashMap;
import java.util.Map;

//Given a string s and a string t, find the minimum window in s which will
// contain all the characters in t in complexity O(n).
//You are given two strings, s and t. Your goal is to find the smallest substring in s
// which contains all the characters present in t. If no such substring exists, return an empty string.
//
//For example, if s = "ADOBECODEBANC" and t = "ABC", the minimum window substring
// containing all characters in t is "BANC".
public class MinimumWindowSubstring {


    public static String minWindow(String s, String t) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : t.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int matched = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            char rightChar = s.charAt(j);
            if (charFrequency.containsKey(rightChar)) {
                charFrequency.put(rightChar, charFrequency.get(rightChar) - 1);
                if (charFrequency.get(rightChar) >= 0) {
                    matched++;
                }
            }
            while (matched == t.length()) {
                if (minLength > j - i + 1) {
                    minLength = j - i + 1;
                    minStart = i;
                }
                char leftChar = s.charAt(i);
                if (charFrequency.containsKey(leftChar)) {
                    if (charFrequency.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequency.put(leftChar, charFrequency.get(leftChar) + 1);
                }
                i++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Minimum Window: " + result);
    }

    }
