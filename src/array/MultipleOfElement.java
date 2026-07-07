package array;

public class MultipleOfElement {

    public static void main(String[] args) {
        int[] a = { 2, 3, 4, 5 };
        multiplicationOfEle(a);

        a = new int[] { 2, 3, 0, 5 };
        multiplicationOfEle(a);

    }

    private static void multiplicationOfEle(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i + 1] * arr[i + 1];
        }

        int left = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            left *= arr[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

}
