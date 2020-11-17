public class Noon {

    public static void main(String[] args) {
        //int[] a= {-2, -3, 4, -1, -2, 1, 5, -3 };
        //int[] a = {-2,-3,-1,-1};
        //int[] a = {2,2,2,2};
        int[] a = {-3, -2, 0, -10, -2};
        //System.out.print(findMximumSun(a));

        int[][] b = {
                {0, 1 ,0 ,0, 0, 1},
                {1, 0, 1, 1 ,0, 1},
                {1, 1, 0, 1, 0 ,1},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0 ,1 ,1 ,0}
    };

        System.out.print(findMaxIland(b));

    }

    private static int findMaxIland(int[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                if (a[i][j] == 1) {
                    bfs(a, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    private static void bfs(int[][] a, int i, int j) {

        if (i < 0 || i >= a.length
                || j < 0 || j >= a[0].length
                || a[i][j] == 0) return;

        a[i][j] = 0;

        bfs(a, i + 1, j);
        bfs(a, i, j + 1);
        bfs(a, i - 1, j);
        bfs(a, i, j - 1);

    }

    private static int findMximumSun(int[] a) {

        int tempSum = a[0];
        int maxSum = a[0];

        for (int i = 1; i < a.length; i++) {

            tempSum += a[i];

            if (tempSum > maxSum) {
                maxSum = tempSum;
            }

            if (tempSum < 0) tempSum = 0;

        }
        return maxSum;
    }
}
