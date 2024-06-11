package aslidingWindow.basic;

public class AnagramOccurence {
    //Count Occurrences of Anagrams
    //Given a word and a text, return the count of the
    // occurrences of anagrams of the word in the text.
    //For eg: word is “for” and the text is “forxxorfxdofr”

    public static void main(String[] args) {
//        String text = "forxxorfxdofr";
//        String word = "for";
        String text = "cbabcacab";
        String word = "abc";

        int result = countAnagrams(text, word);
        System.out.println("Anagram Occurence: " + result);
    }

    public static int countAnagrams(String text, String word) {
        int count = 0;
        int start = 0;
        int matched = 0;
        int[] charFrequencyMap = new int[26];
        for (char c : word.toCharArray()) {
            charFrequencyMap[c - 'a']++;
        }
        for (int end = 0; end < text.length(); end++) {
            char rightChar = text.charAt(end);
            if (charFrequencyMap[rightChar - 'a'] > 0) {
                matched++;
            }
            charFrequencyMap[rightChar - 'a']--;
            if (matched == word.length()) {
                count++;
            }
            if (end >= word.length() - 1) {
                char leftChar = text.charAt(start);
                if (charFrequencyMap[leftChar - 'a'] >= 0) {
                    matched--;
                }
                charFrequencyMap[leftChar - 'a']++;
                start++;
            }
        }
        return count;
    }




}
