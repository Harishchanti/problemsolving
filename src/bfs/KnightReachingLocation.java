package bfs;

public class KnightReachingLocation {
    public static void main(String[] args) {
        int m = 30, n = 30;

        int startX = 1, startY = 1;
        int endX = 30, endY = 30;

        int[] result = new int[1];
        result[0] = Integer.MAX_VALUE;
        int[][] board = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.MAX_VALUE;

        findMinMoves(board, startX - 1, startY - 1, m, n, endX - 1, endY - 1, 0, result);

        System.out.print(result[0]);
    }

    private static void findMinMoves(int[][] board, int startX, int startY, int m, int n, int endX, int endY, int count, int[] result) {

        if (startX < 0 || startX >= m || startY < 0 || startY >= n || board[startX][startY] <= count) return;


        if (startX == endX && startY == endY) {
            result[0] = Math.min(result[0], count);
            return;
        }
        board[startX][startY] = count;


        /*
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
         */
        findMinMoves(board, startX + 2, startY - 1, endX, m, n, endY, count + 1, result);
        findMinMoves(board, startX + 2, startY + 1, endX, m, n, endY, count + 1, result);
        findMinMoves(board, startX - 2, startY - 1, endX, m, n, endY, count + 1, result);
        findMinMoves(board, startX - 2, startY + 1, endX, m, n, endY, count + 1, result);

        findMinMoves(board, startX - 1, startY + 2, endX, m, n, endY, count + 1, result);
        findMinMoves(board, startX - 1, startY - 2, endX, m, n, endY, count + 1, result);
        findMinMoves(board, startX + 1, startY + 2, endX, m, n, endY, count + 1, result);
        findMinMoves(board, startX + 1, startY - 2, endX, m, n, endY, count + 1, result);


    }
}
