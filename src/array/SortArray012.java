package array;

public class SortArray012 {

    public static void main(String[] arg) {
        int[] a = {1, 1, 1, 1, 1, 1, 0, 2, 2, 0};
        print(a);
        sort(a);
        print(a);
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
