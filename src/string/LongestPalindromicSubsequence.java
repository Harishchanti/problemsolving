package string;

import java.util.Arrays;

/*
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {

    static int[][] dp = new int[1001][1001];
    public static void main(String[] args) {
        String input = "bbbab";
        for(int i= 0 ;i < input.length();i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(findLongestPalindromicSubseqence(input));
    }

    private static int findLongestPalindromicSubseqence(String s) {
        return findLongestPalindromicSubseqenceUtil(s, 0, s.length() - 1);
    }

    private static int findLongestPalindromicSubseqenceUtil(String s, int i,
            int j) {

        if (i > j)
            return 0;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == j){
            return dp[i][j] = 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + findLongestPalindromicSubseqenceUtil(s, i + 1, j - 1);
        }

        return dp[i][j] = Math.max(findLongestPalindromicSubseqenceUtil(s, i + 1, j),
                findLongestPalindromicSubseqenceUtil(s, i, j - 1));
    }
}
