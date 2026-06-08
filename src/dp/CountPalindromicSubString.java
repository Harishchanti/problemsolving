package dp;

import java.util.Arrays;
import java.util.Map;

public class CountPalindromicSubString {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(
                countSimpleApproch(s));// T : (O) :n2  and space : (O) : 1

        System.out.println(
                countPS(s));

        System.out.println(PalindromicBluePrint(s));
    }

    private static int PalindromicBluePrint(String s) {
        int n = s.length(), maxLength = 0;
        boolean[][] t = new boolean[n][n];

        for (int l = 1; l <= n; l++) {

            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;

                if (i == j) {
                    t[i][j] = true;
                } else if (i + 1 == j) {
                    t[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    t[i][j] = ((s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]));
                }

                if (t[i][j]) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }

        }
        return maxLength;
    }

    private static int countSimpleApproch(String s) {

        int count = 0;

        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(
                    left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    static int isPalindrome(int i, int j, String s,
            int[][] memo) {

        if (i >= s.length() || i < 0 || j >= s.length() || j < 0) {
            return memo[i][j] = 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1 ? 0 : 2;
        }
        int l = i, r = j;
        while (l <= r) {

            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return memo[i][j] = 0;
            }
        }
        System.out.println(s.substring(i, j + 1));
        return memo[i][j] = 1;
    }

    static int countPS(String s) {
        int n = s.length();

        // Memoization table
        int[][] memo = new int[n + 2][n + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                for (int j = 0; j <= 1; j++) {
                    int l = i, r = i + j;
                    // Check if the substring is palindrome
                    if (isPalindrome(i, j + k, s, memo) == 1) {
                        //System.out.println(s.substring(i, k + 1));
                        res++;
                    }
                }
            }

        }

        return res;
    }

}
