package backtracking;

import java.util.*;

// O(2^n * n) Time and O(n) Space
public class GenerateParenthesis {
    static List<String> result = new ArrayList<String>();

    public static void main(String[] args) {
        generateParenthesis(3);
        result.forEach(System.out::println);
    }

    static public void generateParenthesis(int n) {
        generateParenthesisUtil(n, 0, 0, "");
    }

    static void generateParenthesisUtil(int n, int open, int close,
            String str) {

        if (close > open)
            return;

        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }

        if (open < n) {
            generateParenthesisUtil(n, open + 1, close, str + "(");
        }

        if (open > close) {
            generateParenthesisUtil(n, open, close + 1, str + ")");
        }
    }
}
