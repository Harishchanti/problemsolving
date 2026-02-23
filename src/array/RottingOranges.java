package array;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        //int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }; // -1
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }; // 4
        //int[][] grid = { { 2, 0 }}; // -1
        System.out.println(orangesRottingV2(grid));
    }

    private static int orangesRottingV2(int[][] grid) {
        return BFS(grid);
    }

    private static int BFS(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<IndexDetails> queue = new LinkedList<>();
        int minTimeIntervel = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new IndexDetails(i, j, 1));
                }
            }
        }

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            boolean flag = false;
            for (int q = 0; q < qSize; q++) {

                IndexDetails indexDetails = queue.peek();
                int c = indexDetails.getC();
                int r = indexDetails.getR();

                if (isWithinLimit(grid, r, c + 1) && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    queue.add(new IndexDetails(r, c + 1,
                            indexDetails.getMinutes() + 1));
                    flag = true;
                }

                if (isWithinLimit(grid, r, c - 1) && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    queue.add(new IndexDetails(r, c - 1,
                            indexDetails.getMinutes() + 1));
                    flag = true;
                }

                if (isWithinLimit(grid, r + 1, c) && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.add(new IndexDetails(r + 1, c,
                            indexDetails.getMinutes() + 1));
                    flag = true;
                }

                if (isWithinLimit(grid, r - 1, c) && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.add(new IndexDetails(r - 1, c,
                            indexDetails.getMinutes() + 1));
                    flag = true;
                }
                indexDetails = queue.poll();
                if (flag) {
                    minTimeIntervel = Math.max(minTimeIntervel,
                            indexDetails.getMinutes());
                }

            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minTimeIntervel;

    }

    private static boolean isWithinLimit(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }
        return true;
    }

    static class IndexDetails {
        private int c;
        private int r;
        private int minutes;

        IndexDetails(int r, int c, int minutes) {
            this.r = r;
            this.c = c;
            this.minutes = minutes;

        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }
    }

}
