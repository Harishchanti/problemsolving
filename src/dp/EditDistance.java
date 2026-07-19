package dp;

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        System.out.println(findMinDistance(s1, s2));
    }

    private static int findMinDistance(String s1, String s2) {

        return findMinDistanceR(s1, s2, 0, 0);
    }
    int[][] dp = new int[501][501];
    private static int findMinDistanceR(String s1, String s2, int i, int j) {

        if (i == s1.length()) {
            return s2.length() - j; // insert
        } else if (j == s2.length()) {
            return s1.length() - i; // delete
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return findMinDistanceR(s1, s2, i + 1, j + 1);
        } else {
            int insert = 1 + findMinDistanceR(s1, s2, i, j + 1);
            int delete = 1 + findMinDistanceR(s1, s2, i + 1, j);
            int replace = 1 + findMinDistanceR(s1, s2, i + 1, j + 1);
            return Math.min(insert, Math.min(delete, replace));
        }

    }
}
