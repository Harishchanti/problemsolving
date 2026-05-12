package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Place n queens on an n×n chessboard so that no two attack each other (same row, column, or diagonal).
 Return all valid arrangements, where each solution shows the column position of the queen in each row.

Input:  n = 4
Output: [[2, 4, 1, 3], [3, 1, 4, 2]]
Explanation:  We mainly print column numbers (from first to last row) of every possible configuration.


 */
public class NQueenProblem {
    public static void main(String[] args) {
        int n = 4;
        NQueenProblem nQueenProblem = new NQueenProblem();
        System.out.println(nQueenProblem.solveNQueens(n));
    }

    private List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensUtiles(board, result, 0);
        return result;
    }

    private void solveNQueensUtiles(char[][] board, List<List<Integer>> result,
            int row) {

        if (row >= board.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == '$') {
                        temp.add(j + 1);
                    }
                }
            }
            result.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (iSafePosition(board, row, col)) {
                board[row][col] = '$';// Do Something

                solveNQueensUtiles(board, result, row + 1); // Explore more

                board[row][col] = '.'; // Undo
            }

        }
    }

    private boolean iSafePosition(char[][] board, int row, int col) {
        // check up side
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == '$') {
                return false;
            }
        }

        // check on the left side

        for (int i = col - 1; i >= 0 && row >= 0; i--) {
            if (board[row][i] == '$') {
                return false;
            }
        }

        // check on the right side
        for (int i = col + 1; i < board.length && row < board.length; i++) {
            if (board[row][i] == '$') {
                return false;
            }
        }

        // check on the diagonal Up right side
        for (int i = row - 1, j =
             col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == '$') {
                return false;
            }
        }

        // check on the diagonal Up left side
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == '$') {
                return false;
            }
        }

        return true;

    }
}
