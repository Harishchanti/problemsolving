package dp;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 */
public class WordBreak {

    public static void main(String[] args) {
        String input = "catsandog";
        List<String> words = new ArrayList<>();
        words.add("cats");
        words.add("dog");
        words.add("sand");
        words.add("and");
        words.add("cat");

        Boolean[] memo = new Boolean[301];

        System.out.println(isWordBreakable(input, input.length(), words, memo));
    }

    private static boolean isWordBreakable(String input, int n,
            List<String> words, Boolean[] memo) {
        return isWordBreakableUtils(0, n, input, words, memo);
    }

    private static boolean isWordBreakableUtils(int idx, int n, String input,
            List<String> words, Boolean[] memo) {

        if (idx == n) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int end = idx + 1; end <= n; end++) {

            String part = input.substring(idx, end);

            if (words.contains(part) && isWordBreakableUtils(end, n, input,
                    words, memo)) {
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }

}
