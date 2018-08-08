package array;


public class RearrangePosAndNegativevalues {
    public static void main(String[] arg) {
        int[] a = {2, 4, 1, 34, -3, -11, 4, -1};
        int temp, j = -1;
        printArray(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                j++;
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        printArray(a);

        //Now Arrange Alternatively
        int k = j + 1;
        int b = 0;
        while (b < k && k < a.length) {
            if (a[b] < 0) {
                temp = a[b];
                a[b] = a[k];
                a[k] = temp;
                k++;
                b += 2;
            }
        }
        printArray(a);

    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");

        System.out.println();
    }
}
