package array;

public class PrintAllRepeatingNumberInArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 3, 6, 6};
        int[] b = {5, 3, 1, 3, 5, 5};
        printAllDuplicates(a);
        printAllDuplicates(b);

    }

    private static void printAllDuplicates(int[] a) {
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            int index = (a[i]) % n;
            a[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if ((a[i] / n) >= 2) System.out.print(i + "  ");
        }

        System.out.println();
    }
}
