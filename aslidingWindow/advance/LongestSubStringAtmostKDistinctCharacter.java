package aslidingWindow.advance;

public class LongestSubStringAtmostKDistinctCharacter {
    //  Given a string s and an integer k, return the length of the longest substring of s that contains at
    //  most k distinct characters
    //  Input: s = "eceba", k = 2
    //  Output: 3  Explanation: The substring is "ece" with length 3.

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        int result = longestSubstringLength(s, k);
        System.out.println("Longest Substring Length: " + result);
    }

    public static int longestSubstringLength(String s, int k) {
        int maxLength = 0;
        int start = 0;
        int distinctCount = 0;
        int[] charFrequency = new int[128];
        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            if (charFrequency[rightChar] == 0) {
                distinctCount++;
            }
            charFrequency[rightChar]++;
            while (distinctCount > k) {
                char leftChar = s.charAt(start);
                charFrequency[leftChar]--;
                if (charFrequency[leftChar] == 0) {
                    distinctCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

}
