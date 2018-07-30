package string;

import static java.lang.Math.max;

public class LongestPalindrom {
    public static void main(String[] arg) {
        String s = "BMBBB";//"GEEKSFORGEEKS";
        char seq[] = s.toCharArray();
        System.out.println(findMaxLength(seq, 0, s.length() - 1));
    }

    private static int findMaxLength(char[] seq, int i, int j) {
        if (i == j) return 1;

        if (seq[i] == seq[j] && i + 1 == j) return 2;

        if (seq[i] == seq[j]) return findMaxLength(seq, i + 1, j - 1) + 2;

        return max(findMaxLength(seq, i + 1, j), findMaxLength(seq, i, j - 1));
    }
}
