package backtracking;

import java.util.HashSet;
import java.util.Set;

/*
You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

Each row must contain the digits 1-9 without duplicates.
Each column must contain the digits 1-9 without duplicates.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
Return true if the Sudoku board is valid, otherwise return false

Input: board =
[["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]

Output: true

 */
public class SudokuProblems {
    public static void main(String[] args) {
        char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(isValidSudoku(board));

        char[][] board1 = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '1', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println(isValidSudoku(board1));

        sudokuSolver(board, 0, 0);
    }

    private static void sudokuSolver(char[][] board, int i, int j) {

        if (solveSudoku(board, i, j)) {

            for (int m = 0; m < 9; m++) {
                for (int n = 0; n < 9; n++) {

                    System.out.print(board[m][n]+", ");
                }
                System.out.println();
            }
        }

    }

    private static boolean solveSudoku(char[][] board, int i, int j) {

        if (i == 9)
            return true;

        int nextRow = i;
        int nextCol = j + 1;

        if (nextCol == 9) {
            nextRow = nextRow + 1;
            nextCol = 0;
        }

        if (board[i][j] != '.') {
            return solveSudoku(board, nextRow, nextCol);
        }

        for (char digit = '1'; digit <= '9'; digit++) {

            if (isSafe(board, i, j, digit)) {

                board[i][j] = digit ;

                if (solveSudoku(board, nextRow, nextCol)) {
                    return true;
                }

                board[i][j] = '.';

            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int i, int j, char digit) {

        // check row wise
        for (int r = i, c = 0; c < 9; c++) {
            if (board[r][c] == digit)
                return false;
        }

        // check column wise
        for (int r = 0, c = j; r < 9; r++) {
            if (board[r][c] == digit)
                return false;
        }

        // check within box
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if ((r / 3 == i / 3 && c / 3 == j / 3) && board[r][c] == digit)
                    return false;
            }
        }

        return true;
    }

    static boolean isValidSudoku(char[][] board) {


        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                String row = i + "_ROW_" + board[i][j];
                String col = j + "_COL_" + board[i][j];
                String rc = i / 3 + "_ROW_" + j / 3 + "_COL_" + board[i][j];

                if (set.contains(row) || set.contains(col) | set.contains(rc)) {
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(rc);

            }
        }
        return true;
    }

}
