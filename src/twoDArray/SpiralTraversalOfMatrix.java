package twoDArray;

import java.util.*;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        int R = 4;
        int C = 6;
        int[][] a = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 } };
        printSpiralOrder(R, C, a);
        System.out.println();
        List<Integer> result = printSpiralOrderV2(a);

        result.forEach(o -> System.out.print(o + " "));

    }

    private static List<Integer> printSpiralOrderV2(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;

        int dir = 0;

        int top = 0, down = m - 1;
        int left = 0, right = n - 1;

        while(top <= down && left <= right) {

            dir = dir % 4;

            if(dir == 0) {

                for(int i = left ; i <= right ;i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }

            if( dir == 1) {

                for(int i = top ; i <= down ;i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if( dir == 2) {

                for(int i = right ; i >= left;  i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            }

            if( dir == 3) {

                for(int i = down; i >= top ; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }

            dir++;
        }

        return res;

    }

    private static void printSpiralOrder(int m, int n, int[][] a) {

        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining columns 
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }

    }

}
