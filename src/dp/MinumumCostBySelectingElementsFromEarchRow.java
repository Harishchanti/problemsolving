package dp;

// https://stackoverflow.com/questions/61561888/finding-minimum-cost-in-2d-matrix

public class MinumumCostBySelectingElementsFromEarchRow {
    private static int[][][] dp;

    public static void main(String[] args) {

        int[][] A = {{1, 2, 2},
                {2, 2, 1},
                {2, 1, 2}};

        int K = 3;
        dp = new int[A.length][A[0].length][K + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                for (int k = 1; k <= K; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < A[0].length; j++)
            res = Math.min(res, getMin(A, 0, j, K));

        System.out.println(res);

    }


    private static int getMin(int[][] A, int r, int c, int K) {
        int R = A.length, C = A[0].length;
        if (r > R - 1 || c > C - 1) return Integer.MAX_VALUE;
        if (K == 0) {
            int sum = 0;
            for (int i = r; i < R; i++)
                sum += A[i][c];
            return sum;
        }
        if (dp[r][c][K] != Integer.MAX_VALUE) return dp[r][c][K];
        int min = Integer.MAX_VALUE;
        int rem_rows = R - (r + 1);
        for (int j = 0; j < C; j++) {
            if (j == c && rem_rows >= K) {
                int s = getMin(A, r + 1, j, K);
                if (s != Integer.MAX_VALUE) {
                    min = Math.min(min, s + A[r][c]);
                } else {
                    min = Math.min(min, A[r][c]);
                }

            } else if (j != c) {
                int m = getMin(A, r + 1, j, K - 1);
                if (m != Integer.MAX_VALUE) {
                    min = Math.min(min, m + A[r][c]);
                } else {
                    min = Math.min(min, A[r][c]);
                }
            }
        }
        dp[r][c][K] = min;
        return min;
    }
}
