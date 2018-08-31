package array;

// https://algorithms.tutorialhorizon.com/all-n-length-strings-from-given-string-of-length-k/
public class PermutationOfAllNumber {

    public void print(int n, char[] k, char[] A) {
        if (n <= 0) {
            System.out.print(String.valueOf(A) + " ");
        } else {
            for (int i = 0; i < k.length; i++) {
                A[n - 1] = k[i];
                print(n - 1, k, A);
            }
        }
    }

    public void printNum(int n, int[] k, int[] A) {
        if (n <= 0) {
            for (int i = 0; i < A.length; i++)
                System.out.print(A[i] + " ");
            System.out.print("\n");
        } else {
            for (int i = 0; i < k.length; i++) {
                A[n - 1] = k[i];
                printNum(n - 1, k, A);
            }
        }
    }

    public static void main(String[] args) {
        String k = "ALGO";
        int n = 3;
        int[] a = {1, 2, 3};
        PermutationOfAllNumber i = new PermutationOfAllNumber();
        i.print(n, k.toCharArray(), new char[n]);
        i.printNum(n, a, new int[n]);
    }
}
