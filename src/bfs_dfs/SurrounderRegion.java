package bfs_dfs;

public class SurrounderRegion {

    public static void main(String[] args) {
        char[][] board = { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };

        char[][] board1 = {
                { 'O', 'O' },
                { 'O', 'O' } };

        char[][] board2 =
                { { 'X', 'X', 'X' },
                        { 'X', 'O', 'X' },
                        { 'X', 'X', 'X' } };

        char[][] board3 =
                { { 'O', 'O', 'O' },
                        { 'O', 'O', 'O' },
                        { 'O', 'O', 'O' } };
        printBoard(board3);
        solveV2(board3);
        System.out.println("\n");
        printBoard(board3);
    }

    private static void printBoard(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i != 0 && i != m - 1 && j != 0 && j != m - 1 && board[i][j] == 'O') {

                    boolean[] found = { false };
                    board[i][j] = '1';
                    BFS(board, i, j, m, n, found);

                    if (found[0]) {
                        board[i][j] = 'X';
                    } else {
                        board[i][j] = 'O';
                    }
                }
            }
        }

    }

    private static void BFS(char[][] board, int i, int j, int r, int c,
            boolean[] found) {

        if (i < 0 || i >= r || j < 0 || j >= c || board[i][j] == 'X') {
            return;
        }
        //if (board[i][j] == 'O') {
        found[0] = true;
        //}

        board[i][j] = 'X';

        BFS(board, i + 1, j, r, c, found);
        BFS(board, i - 1, j, r, c, found);

        BFS(board, i, j + 1, r, c, found);
        BFS(board, i, j - 1, r, c, found);

    }

    static int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public static void solveV2(char[][] board) {
        // what if look at the matrix
        // and see all 'O's at the edges
        // if i find one, i do a dfs of that and
        // mark all 'O's with say '*'. after that
        // just count all Os and replace those with 'xs'
        // and revert '*'s with 'Os'.

        // Time complexity is O(m*n)
        int m = board.length; //4
        int n = board[0].length; //4
        boolean zeroFound = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // find edges.
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                        zeroFound = true;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        if (!zeroFound) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    //i=3,j=1
    private static void dfs(char[][] board, int i, int j) {
        if (!isValid(i, j, board.length,
                board[0].length) || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '*';
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
