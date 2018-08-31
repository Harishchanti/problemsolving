package array;

public class ILandProblems {

    public static void main(String[] args) {

        int M[][] = new int[][]{
                {1, 1, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}

        };
        int N[][] = new int[][]{
                {1, 1, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}

        };
        System.out.println(findNoOfIlands(M));
        System.out.println(maxIland(N));

    }

    private static int maxIland(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 1) {
                    int mx = findILandSize(i, j, a);
                    if (mx > max) {
                        max = mx;
                    }
                }
            }
        }
        return max;
    }

    private static int findILandSize(int i, int j, int[][] a) {

        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0) {
            return 0;
        }
        a[i][j] = 0;
        return 1 + findILandSize(i + 1, j, a) + findILandSize(i - 1, j, a) +
                   findILandSize(i, j - 1, a) + findILandSize(i, j + 1, a) +
                   findILandSize(i + 1, j + 1, a) + findILandSize(i - 1, j - 1, a);
    }


    private static int findNoOfIlands(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 1) {

                    DFS(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void DFS(int[][] a, int i, int j) {

        if (i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] == 0)
            return;

        a[i][j] = 0;
        for (int r = i - 1; r <= i + 1; r++) {
            for (int c = j - 1; c <= j + 1; c++) {
                if (r != i || c != j) {
                    DFS(a, r, c);
                }
            }
        }

    }

}
