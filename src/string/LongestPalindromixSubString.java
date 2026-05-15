package string;

public class LongestPalindromixSubString {
    static boolean[][] t = new boolean[1001][1001];
/*
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */
    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }

    static private String longestPalindrome(String s) {

        int n = s.length();
        char[] c = s.toCharArray();
        int maxLength = 0, startIdx = 0;

        for (int l = 1; l <= n; l++) {

            for (int i = 0; i + l - 1 < n; i++) {

                int j = i + l - 1;

                if (i == j) {
                    t[i][j] = true;
                } else if (i + 1 == j) {
                    t[i][j] = (c[i] == c[j]);
                } else {

                    t[i][j] = (c[i] == c[j] && t[i + 1][j - 1]);
                }

                if (t[i][j]) {

                    if ((j - i + 1) > maxLength) {
                        maxLength = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + maxLength);

    }
}
