package company_interview;

public class PrintFibanacciNumber {
    public static void main(String[] args) {
        int N = 10;

        for (int i = 0; i < N; i++) {
            System.out.print(printF(i) + " ");
        }
    }

    private static Integer printF(int n) {
        if (n == 0 || n == 1) return n;

        return printF(n - 1) + printF(n - 2);

    }
}
