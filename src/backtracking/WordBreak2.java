package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []

 */
public class WordBreak2 {
    public static void main(String[] args) {
        String input = "pineapplepenapple";
        List<String> wordDict =
                Arrays.asList("apple","pen","applepen","pine","pineapple");
        List<String> result = new ArrayList<>();
        generate(input, wordDict, result, new StringBuilder(), 0);

        result.forEach(System.out::println);
    }

    static void generate(String s, List<String> wordDict, List<String> res,
            StringBuilder curr, int i) {
        if (i >= s.length()) {
            res.add(curr.toString().trim());
            return;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, i)) {
                int l = curr.length();
                curr.append(word).append(" ");
                generate(s, wordDict, res, curr, i + word.length());
                curr.setLength(l);
            }
        }
    }
}
