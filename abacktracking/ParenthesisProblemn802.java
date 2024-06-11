package abacktracking;

public class ParenthesisProblemn802 {
    //Given n pairs of parentheses, write a function to generate all
    //combinations of well-formed parentheses

    public static void main(String[] args) {
        System.out.println("generateParenthesis(3) = " + generateParenthesis(3));
    }

    private static java.util.List<String> generateParenthesis(int n) {
        java.util.List<String> result = new java.util.ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }

    private static void generateParenthesis(int left, int right, String str, java.util.List<String> result) {
        if (right == 0) {
            result.add(str);
        } else {
            if (left > 0) {
                generateParenthesis(left - 1, right, str + "(", result);
            }
            if (right > left) {
                generateParenthesis(left, right - 1, str + ")", result);
            }
        }
    }
}
