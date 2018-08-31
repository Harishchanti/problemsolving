package array;

import java.util.ArrayList;
import java.util.List;

/*ROW's are childerns columns are toy pirice 
 get toys from each child such a way you get maximum price

 in :
	{ 1, 2 } 
	{ 4, 6} 
	
out : c1 : 1 c2 : 6 = 7

in :
	{ 1, 2, 4}, 
	{ 4, 6, 1 }, 
	{ 7, 3, 2 }, 
	
out : 
    c3: 7 c2: 6 c3: 4 = 17	
    
 in : 
 
    { 1, 5, 4, 2 }, 
	{ 4, 6, 1, 6 }, 
	{ 7, 3, 2, 1 }, 
	{ 3, 5, 1, 2 }
	
out :
   c3: 7 c4: 5  c1: 4 c2 : 6 = 22 
    
*/

public class ChildAndToyProblem {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 5, 4, 2},
                {4, 6, 1, 6},
                {7, 3, 2, 1},
                {3, 5, 1, 2}
        };

        //System.out.println(getMax(a));
        System.out.println(minCount(1, 1, 4, 0));
        System.out.println(minCount(1, 5, 4, 0));
    }

    private static long minCount(long a, long b, long x, long c) {

        if (x == c) {
            return 0;
        }

        if(c > x) {
            return minCount(a,b,x,c-1);
        }
        long r = minCount(a, b, x, c + 1) + a + ((c > x) ? minCount(a, b, x, c - 1)+a : 0);
        long l = minCount(a, b, x, c * 2) + b;

        return Math.min(r, l);
    }

    private static int getMax(int[][] a) {
        int n = a.length;
        int max = 0, i = 0;
        int[][] s = new int[n][n];

        for (i = 0; i < n; i++) {
            s[0][i] = a[0][i];
        }

        for (i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    s[i][j] = max(a[i][j], a[i - 1][j]);
                } else {
                    if (i > 0 && j > 0) {
                        s[i][j] = max(a[i][j] + s[i - 1][j - 1], s[i][j - 1] + s[i - 1][j]);
                    } else {
                        s[i][j] = a[i][j];
                    }
                }
            }
        }

        return max;
    }

    private static int max(int i, int j) {
        return i > j ? i : j;
    }

}
