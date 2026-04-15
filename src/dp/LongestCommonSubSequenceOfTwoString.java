package dp;

import java.util.Arrays;

/*
Input: s1 = "ABC", s2 = "ACD"
Output: 2
Explanation: The longest subsequence which is present in both strings is "AC".

Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 4
Explanation: The longest common subsequence is "GTAB".

Input: s1 = "ABC", s2 = "CBA"
Output: 1
Explanation: There are three longest common subsequences of length 1, "A", "B" and "C".
 */
public class LongestCommonSubSequenceOfTwoString {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(findLCS(s1, s2, m, n, dp));

    }

    private static int findLCS(String s1, String s2, int m,
            int n, int[][] dp) {

        // Base case: If either string is empty, the length of LCS is 0
        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        // If the last characters of both substrings match
        if (s1.charAt(m - 1) == s2.charAt(n - 1))

            // Include this character in LCS and recur for remaining substrings
            return 1 + findLCS(s1, s2, m - 1, n - 1, dp);

        else
            // If the last characters do not match
            // Recur for two cases:
            // 1. Exclude the last character of S1
            // 2. Exclude the last character of S2
            // Take the maximum of these two recursive calls
            return dp[m][n] = Math.max(findLCS(s1, s2, m, n - 1, dp),
                    findLCS(s1, s2, m - 1, n, dp));

    }
}
