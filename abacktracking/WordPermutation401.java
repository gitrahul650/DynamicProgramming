package abacktracking;

public class WordPermutation401 {
    //You are given a string and you are supposed to print all the distinct
    //permutations of the string
    //For example, if you are given the string "abc", then you are supposed to
    //print the following permutations:
    //abc
    //acb
    //bac
    //bca
    //cab
    //cba
    //Please use backtracking to solve this problem

    public static void main(String[] args) {
        String string = "abc";
        permutation(string);
    }

    private static void permutation(String string) {
        permutation(string, "");
    }

    private static void permutation(String string, String prefix) {
        if (string.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < string.length(); i++) {
                String remainder = string.substring(0, i) + string.substring(i + 1);
                permutation(remainder, prefix + string.charAt(i));
            }
        }
    }
}
