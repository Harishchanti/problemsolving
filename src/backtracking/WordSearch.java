package backtracking;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


 */
public class WordSearch {

    static int[][] dx = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) {
        char[][] board = {  { 'A', 'B', 'C', 'E' },
                            { 'S', 'F', 'C', 'S' },
                            { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(isExist(board, word));

    }

    private static boolean isExist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (wordPossible(board, i, j, m, n, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean wordPossible(char[][] b, int i, int j, int m, int n,
            String word, int idx) {

        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= n || b[i][j] == '$') {
            return false;
        }

        if (b[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = b[i][j];
        b[i][j] = '$';

        for (int k = 0; k < 4; k++) {
            int xi = i + dx[k][0];
            int xj = j + dx[k][1];

            if (wordPossible(b, xi, xj, m, n, word, idx + 1)) {
                return true;
            }
        }

        b[i][j] = temp;
        return false;
    }
}
