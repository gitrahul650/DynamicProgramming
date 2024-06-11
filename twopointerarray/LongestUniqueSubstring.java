package twopointerarray;

import java.util.HashSet;
import java.util.Set;

class LongestUniqueSubstring {

  public int lengthOfLongestSubstring(String s) {
    int n = s.length();

    int res = 0;
    int left = 0;
    int right = 0;

    Set<Character> set = new HashSet<>();

    while (right < n) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right++));
        res = Math.max(res, set.size());
      }
      else {
        set.remove(s.charAt(left++));
      }
    }
    return res;
  }

  public static void main(String[] args) {
    LongestUniqueSubstring lus = new LongestUniqueSubstring();
    String s = "abcabcbb";
    int len = lus.lengthOfLongestSubstring(s);
    System.out.println("The length of longest substring is: " + len);
  }
}