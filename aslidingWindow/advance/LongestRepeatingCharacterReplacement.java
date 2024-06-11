package aslidingWindow.advance;



public class LongestRepeatingCharacterReplacement {

    //You are given a string s consisting of uppercase English letters, and an integer k.
    // Your goal is to find the length of the longest subarray in s such that after performing at most k operations,
    // the subarray consists of only one character (i.e., all the characters in the subarray are the same).
    //
    //For example, if s = "ABAB" and k = 2, you can perform two operations to change
    // "ABAB" to "AAAA", resulting in a longest subarray of length 4.

public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int result = longestSubstringLength(s, k);
        System.out.println("Longest Substring Length: " + result);
    }

    public static int longestSubstringLength(String s, int k) {
        int maxLength = 0;
        int start = 0;
        int maxRepeatLetterCount = 0;
        int[] charFrequency = new int[128];
        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            charFrequency[rightChar]++;
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charFrequency[rightChar]);
            while (end - start + 1 - maxRepeatLetterCount > k) {
                char leftChar = s.charAt(start);
                charFrequency[leftChar]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }




}
