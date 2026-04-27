package dp;

import java.util.Arrays;

public class CountPalindromixSubString {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(
                countSimpleApproch(s));// T : (O) :n2  and space : (O) : 1

        System.out.println(
                countPS(s));
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
