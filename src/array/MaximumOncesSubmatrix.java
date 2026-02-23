package array;

public class MaximumOncesSubmatrix {

    public static void main(String[] args) {
        int[][] a = new int[][] {
                { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 } };

        findMaxmatrix(a, 5, 5);

    }

    private static void findMaxmatrix(int[][] a, int m, int n) {
        int i = 0, j = 0;
        int s[][] = new int[m][n];
        int max = 0;
        for (i = 0; i < m; i++) {
            s[i][0] = a[i][0];
        }
        for (i = 0; i < n; i++) {
            s[0][i] = a[0][i];
        }

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (a[i][j] == 1) {
                    s[i][j] =
                            1 + min(s[i - 1][j], s[i][j - 1], s[i - 1][j - 1]);
                    max = Math.max(max, s[i][j]);
                }
            }
        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(s[i][j] + " "); // = 1 +
                // min(a[i-1][j],a[i][i-1],a[i-1][j-1]);
            }
            System.out.println();
        }

        System.out.println(
                "Maximum square sub array size : " + max + " * " + max);
    }

    private static int min(int i, int j, int k) {
        int f = Math.min(i, j);
        return Math.min(f, k);
    }

}
