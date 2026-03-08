package backtracking;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/1940949460/
// explaination : https://www.youtube.com/watch?v=1TGTBDWY1s4

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    static String[] char_map =
            new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno",
                    "pqrs", "tuv", "wxyz" };
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String key = "23";
        letterCombinations(key, "");
        result.forEach(o -> System.out.print(o + " "));
    }

    private static void letterCombinations(String digits, String output) {

        if (digits.isEmpty()) {
            result.add(output);
            return;
        }

        String key = char_map[Character.getNumericValue(digits.charAt(0))];

        for (int i = 0; i < key.length(); i++) {
            letterCombinations(digits.substring(1), output + key.charAt(i));
        }
    }
}
