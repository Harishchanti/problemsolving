package dp.oneDbases;

import java.util.Arrays;

public class DecodeWays {
    static int[] dp = new int[101];

    public static void main(String[] args) {
        String s = "011";// "1" , "01"
        Arrays.fill(dp, -1);
        System.out.println(solveCount(0, s.toCharArray(), s.length()));
    }

    static int solveCount(int i, char[] s, int n) {

        if (dp[i] != -1)
            return dp[i];

        if (i >= n)
            return dp[i] = 1;

        if (s[i] == '0') {
            return dp[i] = 0;
        }

        int result = solveCount(i + 1, s, n);
        if ((i + 1) < n) {
            if (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7')) {
                result += solveCount(i + 2, s, n);
            }
        }
        return dp[i] = result;
    }
}
