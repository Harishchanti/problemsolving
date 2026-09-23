package string;

import java.util.ArrayList;
import java.util.List;

public class PrintAllNumbersInLexicographicalOrder {
    public static void main(String[] args) {
        int n = 13;
        List<Integer> result = new ArrayList<>();

        int curr = 1;

        for (int i = 0; i < n; i++) {
            result.add(curr);

            if (curr * 10 <= n) {
                curr = curr * 10; // go deeper
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10; // backtrack
                }
                curr++;
            }
        }

        System.out.println(result);


        int N = 13;
        List<Integer> result1 = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(i, N, result1);
        }

        System.out.println(result1);
    }
    private static void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) return;

        result.add(curr);

        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > n) return;
            dfs(next, n, result);
        }
    }
}
