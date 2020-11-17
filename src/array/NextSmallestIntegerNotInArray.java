package array;

import java.util.Arrays;

public class NextSmallestIntegerNotInArray {
    public static void main(String[] args) {

        //if (flag) return 1;
        int a[] = {1, 2, 3, 4, 6};
        int b[] = {1, 2, 3};
        int c[] = {-1, -2, -3};

        System.out.println(findsmall(a) + " : " + findsmall(b) + " : " + findsmall(c));
        // System.out.println(findsmall(b));
        // System.out.println(findsmall(c));

        //System.out.println();

        System.out.println(findSmallestOptimized(a) + " : " + findSmallestOptimized(b) + " : " + findSmallestOptimized(c));
        //System.out.println(findSmallestOptimized(b));
        //System.out.println(findSmallestOptimized(c));

    }

    private static int findSmallestOptimized(int[] a) {
        boolean per = true;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) per = false;
        }

        if (per) return 1;

        for (int i = 0; i < n; i++) {
            if (a[i] <= 0 || a[i] > n) a[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            a[(a[i] - 1) % n] += n;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] <= n) return i + 1;
        }
        return n + 1;
    }

    private static int findsmall(int[] a) {

        boolean[] seen = new boolean[a.length + 1];
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] <= a.length) {
                seen[a[i]] = true;
            }
        }

        for (i = 1; i < seen.length; i++)
            if (!seen[i]) return i;

        return i;
    }
}
